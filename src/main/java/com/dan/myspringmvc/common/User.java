package com.dan.myspringmvc.common;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private String name;
    private String city;
    private String code;
}
