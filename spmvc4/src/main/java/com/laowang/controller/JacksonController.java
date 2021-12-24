package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
