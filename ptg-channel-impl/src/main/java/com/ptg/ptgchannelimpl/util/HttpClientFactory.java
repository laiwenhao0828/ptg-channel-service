package com.ptg.ptgchannelimpl.util;


import com.ptg.channel.req.ChannelHttpParamConfig;
import com.ptg.ptgchannelimpl.annotation.GatewayHttpMethod;
import com.ptg.ptgchannelimpl.exception.GatewayException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Slf4j
public class HttpClientFactory {
    /**
     * 方法名称和方法对象的缓存
     */
    private final Map<String, Method> methodMaps = new HashMap<>();
    //初始化最大连接数
    private int nMaxTotal = 200;
    //初始化最大路由（域名对应的最大连接数）
    private int nMaxPerRoute = 50;
    /**
     * 等待数据返回的超时时间 200秒
     */
    private int socketTimeout = 200000;
    /**
     * 等待连接建立的超时时间 30秒
     */
    private int connectTimeout = 30000;
    /**
     * 从连接池获取连接的超时时间 10秒
     */
    private int connectionRequestTimeout = 10000;

    /**
     * 监控间隔时间，单位：秒
     */
    private final int MONITER_INTERVAL = 5;
    /**
     * 连接空闲时间，单位：秒
     */
    private final int IDEL_TIME = 30;

    private HttpClientFactory() {
    }

    private static final class HttpClientFactoryInner {
        private static final HttpClientFactory httpClientFactory = new HttpClientFactory();
    }

    public static HttpClientFactory get() {
        return HttpClientFactoryInner.httpClientFactory;
    }

    // 连接管理器
    private PoolingHttpClientConnectionManager pool;
    // 请求配置
    private RequestConfig requestConfig;

    /* no ssl check connection pool */
    private PoolingHttpClientConnectionManager noSSLCheckConnPool;
    private RequestConfig noSSLCheckRequestConfig;

    /**
     * 创建连接池和配置对象
     *
     * @throws GatewayException
     */
    public HttpClientFactory buildSimpleConnectionPool() throws GatewayException {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(builder.build());
            // 配置同时支持 HTTP 和 HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslFactory).build();
            // 初始化连接管理器
            pool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            pool.setMaxTotal(nMaxTotal);
            pool.setDefaultMaxPerRoute(nMaxPerRoute);
            // 初始化配置对象
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();
            stopWatch.stop();
            log.info(String.format("HttpClientFactroy 初始化完毕,耗时 %s", stopWatch.toString()));
            IdleConnectionMonitor moniter = new IdleConnectionMonitor(pool, "simplePool");
            moniter.setDaemon(true);
            moniter.start();
            return this;
        } catch (Exception e) {
            log.error(String.format("HttpClientFactory 初始化失败: %s", e.getMessage()), e);
            throw new GatewayException(e);
        }
    }

    /**
     * 无需进行ssl验证的https连接池
     *
     * @throws GatewayException
     */
    public HttpClientFactory buildNoSSLCheckConnectionPool() throws GatewayException {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            //采用绕过验证的方式处理https请求
            SSLContext sslcontext = createIgnoreVerifySSL();
            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext))
                    .build();
            // 初始化连接管理器
            noSSLCheckConnPool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            noSSLCheckConnPool.setMaxTotal(nMaxTotal);
            noSSLCheckConnPool.setDefaultMaxPerRoute(nMaxPerRoute);
            // 初始化配置对象
            noSSLCheckRequestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();
            stopWatch.stop();
            log.info(String.format("NoSSLCheck HttpClientFactroy 初始化完毕,耗时 %s", stopWatch.toString()));
            IdleConnectionMonitor moniter = new IdleConnectionMonitor(pool, "noSSLAuthPool");
            moniter.setDaemon(true);
            moniter.start();
            return this;
        } catch (Exception e) {
            log.error(String.format("NoSSLCheck HttpClientFactory 初始化失败: %s", e.getMessage()), e);
            throw new GatewayException(e);
        }
    }

    private SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }


    /**
     * 过期连接和空闲连接监控线程，使用守护线程
     * 空闲超过一分钟的连接回收
     */
    private class IdleConnectionMonitor extends Thread {

        private PoolingHttpClientConnectionManager pool;
        private String name;

        public IdleConnectionMonitor(PoolingHttpClientConnectionManager pool, String name) {
            this.pool = pool;
            this.name = name;
        }

        @Override
        public void run() {
            log.info(String.format("%s moniter thread start", name));
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(MONITER_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Objects.isNull(pool)) {
                    log.error(String.format("%s pool is null", name));
                    continue;
                }
                // 关闭过期连接
                pool.closeExpiredConnections();
                // 关闭空闲连接
                pool.closeIdleConnections(IDEL_TIME, TimeUnit.SECONDS);
                log.info(String.format("%s moniter thread clear httpclient end", name));
            }
        }

    }

    /**
     * 获取客户端连接对象
     *
     * @return
     */
    public CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                // 设置连接池管理
                .setConnectionManager(pool)
                // 设置请求配置
                .setDefaultRequestConfig(requestConfig)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
        return httpClient;
    }

    /**
     * 获取https无ssl验证的客户端对象
     *
     * @return
     */
    public CloseableHttpClient getNoSSLCheckHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                // 设置连接池管理
                .setConnectionManager(noSSLCheckConnPool)
                // 设置请求配置
                .setDefaultRequestConfig(noSSLCheckRequestConfig)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
        return httpClient;
    }

    /**
     * 创建方法缓存
     */
    public HttpClientFactory buildMethodCahe() throws GatewayException {
        Class methodClass = HttpClientFactory.class;
        Method[] methods = methodClass.getDeclaredMethods();
        if (methods.length == 0) {
            throw new GatewayException("HttpClientFactory.class 没有public方法");
        }
        for (Method method : methods) {
            // 关闭class文件检测
            if (method.isAccessible()) {
                method.setAccessible(false);
            }
            // 只有指定的方法才进行缓存
            if (method.isAnnotationPresent(GatewayHttpMethod.class)) {
                String methodName = method.getName();
                methodMaps.put(methodName, method);
            }
        }
        return this;
    }

    /**
     * 通过方法名获取方法对象
     *
     * @param key
     * @return
     */
    public Method getMethod(String key) {
        return methodMaps.get(key);
    }

    /**
     * aop调用方法
     *
     * @param name
     * @param key
     * @param args
     * @return
     * @throws GatewayException
     */
    public String methodInvoke(String name, String key, Object[] args) throws GatewayException {
        Method method = getMethod(name);
        ObjectAssert.requireNotNull(method, "方法对象不存在");
        Object obj = null;
        String exception = "";
        Exception returnE = null;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            obj = method.invoke(this, args);
        } catch (Exception e) {
            returnE = e;
            exception = e.getCause() == null ? e.getMessage() : e.getCause().toString();
            log.error("methodInvoke message", e);
        }
        stopWatch.stop();
        StringBuilder message = new StringBuilder();
        message.append("[").append(key).append("]").append(" 参数:").append(Arrays.toString(args));
        message.append(" 时间:").append(stopWatch.toString());
        message.append(" 返回:").append(String.valueOf(obj));
        message.append(" 异常:").append(exception);
        message.append(" 连接池simple ").append(pool.getTotalStats().toString());
        message.append(" 连接池noSSLCheck ").append(noSSLCheckConnPool.getTotalStats().toString());
        log.info(message.toString());
        // 出现异常时，抛出异常
        if (Objects.nonNull(returnE)) {
            throw new GatewayException(returnE);
        }
        return Objects.isNull(obj) ? null : String.valueOf(obj);
    }

    public static void main(String[] args) {

        try {
            HttpClientFactory.get().buildMethodCahe().buildSimpleConnectionPool().buildNoSSLCheckConnectionPool();
        } catch (GatewayException e) {
            e.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                try {
                    String methodName = "sendHttpPost";
                    String url = "http://192.168.1.73/doc/Compensatory.html";

                    Object[] obj = {url};

                    if (Objects.nonNull(HttpClientFactory.get().getMethod(methodName))) {
                        String s = HttpClientFactory.get().methodInvoke(methodName, url, obj);
                        if (StringUtils.isBlank(s)) {
                            log.info("返回信息错误" + s);
                        }
                        log.info("返回信息" + s);
                    }
                } catch (Exception e) {
                    log.error("调用异常");
                    e.printStackTrace();
                }
            }
        }.start();
    }
    /**
     * 请求是否成功
     *
     * @param statusCode
     * @return
     */
    public static boolean isRequestSuccess(int statusCode) {

        return statusCode == 200;
    }
    @GatewayHttpMethod
    private String aNSend(String url,List<ChannelHttpParamConfig> channelHttpParamConfigList) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(300000).setConnectTimeout(300000).build();
        httpPost.setConfig(requestConfig);
        String respMessage = "";
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            for(ChannelHttpParamConfig channelHttpParamConfig : channelHttpParamConfigList){
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair(channelHttpParamConfig.getHttpParamName(), channelHttpParamConfig.getHttpParamValue());
                nameValuePairs.add(basicNameValuePair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                respMessage = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            log.error("ainongSend error:",e);
            respMessage = "";
        }
        return respMessage;
    }
    @GatewayHttpMethod
    public String sendRawHttpPost2(String httpUrl, List<ChannelHttpParamConfig> channelHttpParamConfigList) throws Exception {
        CloseableHttpClient client = getNoSSLCheckHttpClient();
        HttpPost httpPost = new HttpPost(httpUrl);
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            for (ChannelHttpParamConfig channelHttpParamConfig : channelHttpParamConfigList) {
                if (channelHttpParamConfig.getHttpParamName().startsWith(Constants.HTTP_HEAD_FALG)) {
                    String headName = getHeadName(channelHttpParamConfig.getHttpParamName());
                    httpPost.addHeader(headName, channelHttpParamConfig.getHttpParamValue());
                } else {
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair(channelHttpParamConfig.getHttpParamName(), channelHttpParamConfig.getHttpParamValue());
                    nameValuePairs.add(basicNameValuePair);
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            response = client.execute(httpPost);
            entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() >= 300) {
                if (response.getStatusLine().getStatusCode() != 302) {
                    throw new GatewayException(
                            "HTTP Request is not success, URI is " + httpPost.getURI() + ", Response code is " + response.getStatusLine().getStatusCode());
                }
                // 处理http返回码302的情况（302为重定向，取出重定向url）
                Header[] hs = response.getHeaders("Location");
                if (hs.length > 0) {
                    String strUrl = hs[0].toString();
                    if (strUrl.indexOf("http") >= 0) {
                        return strUrl.substring(strUrl.indexOf("http"));
                    }
                }
                throw new GatewayException(
                        "HTTP Request is not success, URI is " + httpPost.getURI() + ", Response code is " + response.getStatusLine().getStatusCode());
            }

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                responseContent = EntityUtils.toString(entity, "utf-8");
            }

        } catch (Exception e) {
            throw new GatewayException(e);
        } finally {
            // 释放资源
            EntityUtils.consume(entity);
            if (response != null) {
                response.close();
            }
        }
        return responseContent;
    }

    @GatewayHttpMethod
    public String sendGet(String url, List<ChannelHttpParamConfig> channelHttpParamConfigList) throws Exception {
        String result = "";
        CloseableHttpResponse response = null;
        HttpEntity entity = null;

        CloseableHttpClient httpClient = getHttpClient();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(url).append("?");
            for (ChannelHttpParamConfig channelHttpParamConfig : channelHttpParamConfigList) {
                if (!channelHttpParamConfig.getHttpParamName().startsWith(Constants.HTTP_HEAD_FALG)) {
                    stringBuilder.append(channelHttpParamConfig.getHttpParamName()).append("=").append(channelHttpParamConfig.getHttpParamValue()).append("&");
                }
            }
            HttpGet get = new HttpGet(stringBuilder.toString());
            get.setHeader("Content-type", "application/json");
            response = httpClient.execute(get);
            entity = response.getEntity();
            if (Objects.nonNull(entity)) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            throw new GatewayException(e);
        } finally {
            EntityUtils.consume(entity);
            if (Objects.nonNull(response)) {
                response.close();
            }
        }
        return result;
    }

    private String getHeadName(String httpParamName) {
        return httpParamName.substring(httpParamName.lastIndexOf("$") + 1, httpParamName.length());
    }

    private String sendHttpPost(HttpPost httpPost) throws Exception {
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            CloseableHttpClient httpClient = getHttpClient();
            // 配置请求信息
            httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 执行请求
            response = httpClient.execute(httpPost);
            // 得到响应实例
            entity = response.getEntity();
            // 判断响应状态
            if (response.getStatusLine().getStatusCode() >= 300) {
                throw new GatewayException(
                        "HTTP Request is not success, URI is " + httpPost.getURI() + ", Response code is " + response.getStatusLine().getStatusCode());
            }
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                if (!Objects.isNull(entity)) {
                    responseContent = EntityUtils.toString(entity, "utf-8");
                }
                log.info("返回报文信息responseContent=" + responseContent);
            }
        } catch (Exception e) {
            throw new GatewayException(e);
        } finally {
            EntityUtils.consume(entity);
            if (response != null) {
                response.close();
            }
        }
        return responseContent;
    }
}





