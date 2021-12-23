package com.laowang.controller;

import com.laowang.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/validate")
public class LoginValidationController {

    @RequestMapping("/1")
    public String login1(@Valid Person person){
        System.out.println(person);
        return "forward:/index.jsp";
    }
}
