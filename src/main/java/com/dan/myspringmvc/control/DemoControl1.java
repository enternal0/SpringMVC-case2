package com.dan.myspringmvc.control;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  @RequestMapping来处理生产和消费对象
 */
@RestController
@RequestMapping(value = "/demo1")
public class DemoControl1 {

    @RequestMapping(value = "/pro1",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public String producer1(){
        Map<String,String> info=new HashMap<>();
        info.put("date_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        info.put("username","jack");
        return new Gson().toJson(info);
    }
    @RequestMapping(value = "/pro2",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public Map producer2(){
        Map<String,String> info=new HashMap<>();
        info.put("date_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        info.put("username","jack");
        return info;
    }
    @RequestMapping(value = "/pro22",method = RequestMethod.GET)
    @ResponseBody
    public Map producer21(){
        Map<String,String> info=new HashMap<>();
        info.put("date_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        info.put("username","jack");
        return info;
    }
    @RequestMapping(value = "/pro3",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public User producer3(){
        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("00000");
        user.setAge(18);
        return user;
    }

    @RequestMapping(value = "consumer1",consumes = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public User consumer1(@RequestBody User user){
        user.setPassword("11111");
        user.setUsername("Welcome "+user.getUsername());
        return user;
    }
    @RequestMapping(value = "consumer2",method = RequestMethod.POST)
    @ResponseBody
    public User consumer2(@RequestBody User user){
        user.setPassword("11111");
        user.setUsername("Welcome "+user.getUsername());
        return user;
    }
    @Data
    class User{
        private String username;
        private String password;
        private Integer age;
    }


}
