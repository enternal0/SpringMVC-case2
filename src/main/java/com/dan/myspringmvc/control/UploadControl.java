package com.dan.myspringmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadControl {

    @RequestMapping(value = "upload",method = RequestMethod.GET)
    public ModelAndView modelAndView(){
        return new ModelAndView("upload");
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ModelAndView upload(@RequestPart("head")  MultipartFile multipartFile){
//      按照base64的格式来取需要的数据 data:image/jpeg;base64
        Map<String,Object> map=new HashMap<>();
        try {
            byte[] bytes=multipartFile.getBytes();
            String value=Base64.getEncoder().encodeToString(bytes);
            String filename=multipartFile.getOriginalFilename();
            String extend=filename.substring(filename.lastIndexOf(".")+1);
            map.put("head_data",String.format("data:image/%s;base64,%s",extend,value));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("upload",map);
    }

}
