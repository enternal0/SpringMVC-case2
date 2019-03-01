package com.dan.myspringmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class HelloWorldControl {

    @RequestMapping(value = {"","index"})
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        Map<String,String> info=new HashMap<>();
        info.put("date_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        modelAndView.addObject(info);
        return modelAndView;
    }
}
