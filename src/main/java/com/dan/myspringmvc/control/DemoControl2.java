package com.dan.myspringmvc.control;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * /demo2/pojo?username=zhangsan&password=000&Address.name=xian&Address.code=012
 * SpringMVC框架会按照请求参数名和POJO属性名进行自动匹配
 */
@Controller
@RequestMapping
public class DemoControl2 {

   @RequestMapping(value = "/pojo")
    public String requestPOJOHandle(User user){
       System.out.println(user);
      return "success";
    }

    @Data
   public static class User{
        private String username;
        private String password;
        private Address  address;
    }

   @Data
   public static class Address{
       private String name;
       private String code;
   }

    /**
     * ServletAPI主要是指控制器方法参数类型为Java Servlet API 中的类
     * @return
     */
   @RequestMapping(value = "/servlet0")
   public String requestServletHandle01(HttpServletRequest request){
       System.out.println(request.getParameter("name"));
       return "success";
   }


}
