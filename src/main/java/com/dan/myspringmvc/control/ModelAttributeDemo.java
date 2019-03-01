package com.dan.myspringmvc.control;

import com.dan.myspringmvc.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttributeDemo {
    /**
     * 访问控制器中的任何一个请求处理方法栈，SpringMVC会先执行该方法
     * 并将返回值以user为键添加到模型中
     */
    @ModelAttribute(value = "user")
    public User getUser(){
       User user=new User();
       user.setCity("xian");
       user.setName("A");
       return user;
    }
    /**
     * 模型数据会赋值给User的入参，然后再根据HTTP请求的消息进一步填充覆盖User对象
     *
     * */
    @RequestMapping(value = "mondelHandle")
    public String modelHandle(@ModelAttribute(value = "user") User user){
        user.setCode("012");
        System.out.println(user);
       return "success";
    }
}
