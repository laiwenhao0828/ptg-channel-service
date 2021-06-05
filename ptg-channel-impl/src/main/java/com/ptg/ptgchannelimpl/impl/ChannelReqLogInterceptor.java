package com.ptg.ptgchannelimpl.impl;



import com.ptg.ptgchannelimpl.annotation.ChannelReqLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;


/**
 * @author xuconghui
 * @time 2018/5/10
 * @description
 */


@Aspect
@Component
@Slf4j
public class ChannelReqLogInterceptor {

    /**
     * 埋点切点
     */
    @Pointcut(value = "execution(* com.ptg.ptgchannelimpl.impl.ChannelInvokeServiceImpl.invoke(..))")
    public void nodePointcut() {
    }

    /**
     * 埋点执行
     *
     * @param joinPoint
     * @return
     */
    @Around("nodePointcut()")
    public Object nodeHandler(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature msg = (MethodSignature) signature;
            Object target = joinPoint.getTarget();
            //获取注解标注的方法
            Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
            log.info("埋点触发,插入流水表:{}", method);
            //通过方法获取注解
            if (method.isAnnotationPresent(ChannelReqLog.class)) {
                ChannelReqLog channelReqLog = method.getAnnotation(ChannelReqLog.class);
                //做响应入库处理

            }
        } catch (NoSuchMethodException e) {
            log.error("埋点请求三方日志信息入库异常>>>", e);
        }
        return result;
    }


}
