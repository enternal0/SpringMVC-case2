package com.dan.myspringmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 定义一个异常处理类
 * 1. 使用 @ResponseStatus注解将异常映射为HTTP状态码
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Parameter Invaild")
   public class RequestParamInvalidException extends RuntimeException {
}

