package com.dan.myspringmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceControlHandleException {
//       把他们的方法都搬到这
           @ExceptionHandler(value = MyHandlerException.class)
           @RequestMapping
           public ModelAndView handlerException(MyHandlerException e) {
               String message = e.getMessage();
               ModelAndView modelAndView = new ModelAndView();
               modelAndView.addObject("error_message", message);
               modelAndView.setViewName("exception");
                return modelAndView;
           }
}
