package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/req")
public class RequestController {

    @RequestMapping("/test5")
    public String getCookie(@CookieValue("JSESSIONID") String jSessionId){
        System.out.println(jSessionId);
        return "success";
    }

    @RequestMapping("/test4")
    public String getRequestHeader1(@RequestHeader(name = "User-Agent") String agent){
        System.out.println(agent);
        return "success";
    }

    @RequestMapping("/test1")
    public String getRequestParam1(String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/test2")
    public String getRequestParam2(@RequestParam String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/test3")
    public String getRequestParam3(@RequestParam(name = "username",required = false,defaultValue = "defualt username") String name){
        System.out.println(name);
        return "success";
    }
}
