package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jackson")
public class JacksonController {

    @ResponseBody
    @RequestMapping(value = "/1")
    public List<User> json1(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"xiongda",11,"23r2d98hfi"));
        users.add(new User(2,"xionger",10,"ase43tg3"));
        users.add(new User(3,"zhangsan",20,"45y3456"));
        users.add(new User(4,"lisi",24,"g,-405y-"));
        users.add(new User(5,"wangwu",28,"f345y5=[][9i"));
        return users;
    }

    /*
    * 不管啥返回形式，注解了ResponseBody后都会把内容装在请求体中直接返回给客户端浏览器，有些消息通过服务器转换别的显示格式，过滤后剩下
    * 的消息让客户端浏览器自己渲染解析
    * */
    @ResponseBody
    @RequestMapping("/2")
    public String json2(){
        return "<h1>Hello,Jackson!!~~~</h1>";
    }

    /*
    * RequestBody接收并转化前端数据给参数，
    * ResponseBody携带后端数据发送给前台
    * */
    @ResponseBody
    @RequestMapping("/3")
    public User json3(@RequestBody User user){
        System.out.println(user);
        return user;
    }
}
