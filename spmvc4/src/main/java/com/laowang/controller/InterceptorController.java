package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 请求打过来的时候，控制台这样的输出顺序：
* preHandle.....1.......
preHandle.......2......
interceptor Controller method..........
postHandle.......2......
postHandle......1.....
resolveViewName......................
THIS IS SUCCESS.JSP.
afterCompletion.........2......
afterCompletion.......1........
* */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/1")
    public String intercept1(){
        System.out.println("interceptor Controller method..........");
        return "success";
    }
}
