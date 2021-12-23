package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vs")
public class ViewResolverController {

    @RequestMapping("/1")
    public String testViewResolver1(){
        System.out.println("testViewResolver1-Controller.................");
        return "laowang:/index.jsp";
    }

    /*
    * 自定义MyViewResolver视图解析器只拦截 前缀laowang:的请求，拦截不了这个，InternalResourceViewResolver也拦截不到这个，
    * 就报异常了
    * */
    @RequestMapping("/2")
    public String testViewResolver2(){
        System.out.println("testViewResolver2-Controller.................");
        return "laoli:/index.jsp";
    }
}
