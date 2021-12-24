package com.laowang.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping("/entity")
public class EntityController {

    /*
    * 【注意】：GET方法不好使，地址栏直接输入参数到不了HttpEntity，
    * POST方法发送给后台的数据才能放进HttpEntity里面，其它方法没试过，POST可以
    * */
    @RequestMapping("/1")
    public String entity1(HttpEntity<String> httpEntity){
        System.out.println(httpEntity);
        return "forward:/login.jsp";
    }

    @RequestMapping("/2")
    public ResponseEntity<String> entity2(){
        String str = "<h2>Hello,ResponseEntity.";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Set-Cookie","username=Laowang");
        return new ResponseEntity<String>(str,httpHeaders, HttpStatus.OK);
    }
}
