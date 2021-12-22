package com.laowang.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/pvc")
public class PathVariableController {

    /*
    * GET方式的url路径请求参数 @RequestParam
    * 地址栏：http://localhost:8080/spmvc2_war_exploded/pvc/test1?name=zhangsan
    * */
    @RequestMapping("/test1")
    public String pvcTest1(@RequestParam String name, Map<String,String> map){
        System.out.println(name);
        map.put("hello",name);
        return "hello";
    }

    /*
    * REST风格，GET方式，@PathVariable 路径变量
    * 地址栏：http://localhost:8080/spmvc2_war_exploded/pvc/test2/lisi
    * */
    @RequestMapping("/test2/{name}")
    public String pvcTest2(@PathVariable String name){
        System.out.println(name);
        return "hello";
    }

    /*
     * REST风格，GET方式，@PathVariable 路径变量，指定变量名，与mapping的花括号变量对应
     * 地址栏：http://localhost:8080/spmvc2_war_exploded/pvc/test3/lisi
     * */
    @RequestMapping("/test3/{username}")
    public String pvcTest3(@PathVariable("username") String name){
        System.out.println(name);
        return "hello";
    }

    /*
     * REST风格，GET方式，@PathVariable 路径变量，指定变量名，与mapping的花括号变量对应
     * 地址栏：http://localhost:8080/spmvc2_war_exploded/pvc/test4/1/lisi
     * */
    @RequestMapping("/test4/{id}/{name}")
    public String pvcTest4(@PathVariable("id") Integer id,@PathVariable("name") String username){
        System.out.println(id+"   +++++++++++++++   "+username);
        return "hello";
    }
}
