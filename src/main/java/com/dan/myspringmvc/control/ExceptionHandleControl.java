package com.dan.myspringmvc.control;

import com.dan.myspringmvc.exception.AdviceControlHandleException;
import com.dan.myspringmvc.exception.MyHandlerException;
import com.dan.myspringmvc.exception.RequestParamInvalidException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/exception")
public class ExceptionHandleControl {
    /**
     * 1. 使用 @ResponseStatus注解将异常映射为HTTP状态码
     * @param username
     * @return
     */
    @RequestMapping(value = "/user")
    public ModelAndView User(@RequestParam("user") String username){
        if(username.isEmpty()){
//            throw new RequestParamInvalidException();
            throw new MyHandlerException();
        }
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("username",username);
        return modelAndView;
    }

    /**
     * 2. 用@ExceptionHandler 注解来处理异常
     *
     * 处理上传无效的异常类
     * 用控制器通知来实现，就先把这个屏蔽掉
     */
    @ExceptionHandler(value = MyHandlerException.class)
    @RequestMapping
    public ModelAndView handlerException(MyHandlerException e){
        String message=e.getMyMessage();
       ModelAndView modelAndView=new ModelAndView("exception");
       modelAndView.addObject("message",message);
       return modelAndView;
    }


}
