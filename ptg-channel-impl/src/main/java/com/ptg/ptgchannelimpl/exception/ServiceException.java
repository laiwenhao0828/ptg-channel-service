
package com.ptg.ptgchannelimpl.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author xuconghui
 * @Date 2020/10/15 15:25
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String code, String msg, String message) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String message, Throwable cause, String code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }
    public ServiceException(Throwable cause, String code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
