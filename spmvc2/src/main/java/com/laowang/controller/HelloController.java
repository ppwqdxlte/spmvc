package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    /*
    * 请求地址，也是目的地址：http://localhost:8080/项目URI/hello/hello
    *
    * */
    @RequestMapping("/hello")
    public String hello(Map<String,String> map){
        map.put("hello","hello Spring mvc~~~~~~~~~~");
        return "hello";
    }
    /*
    * POST 方式 不能从uri直接输入，必须表单提交等方式跳转到目的地址
    *
    * 目的地址：http://localhost:8080/项目URI/hello/world
    * 注意，上述地址不能直接在浏览器地址栏里输入！
    * */
    @RequestMapping(value = "/world",method = RequestMethod.POST)
    public String world(Map<String,String> map){
        map.put("hello","Hello My Big World!!~~!!~~");
        return "hello";
    }

}
