package com.example.yang.exception;

import com.example.yang.result.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class APIException extends RuntimeException{
    private final int code;
    private final String msg;
    public APIException() {
        this(ResultCode.FAILED);
    }
    public APIException(ResultCode failed) {
        this.code = failed.getCode();
        this.msg = failed.getMsg();
    }
}
