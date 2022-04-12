package com.lyj.security.exception;

import javax.security.sasl.AuthenticationException;

/**
 * 自定义验证码异常
 */
public class KaptchaNotMatchException extends AuthenticationException {

    public KaptchaNotMatchException(String msg) {
        super(msg);
    }

    public KaptchaNotMatchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
