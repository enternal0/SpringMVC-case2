package com.dan.myspringmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "username参数异常")
public class MyHandlerException extends RuntimeException{
    public String getMyMessage(){
     return getMessage();
    }
}
