package com.laowang.controller;

import com.laowang.bean.User;
import com.laowang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uc")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/save")
    public String save(){
        User user = new User();
        userDao.save(user);
        return "hello";
    }
    /*
    * 地址栏：http:......../delete?i=1
    * */
    @RequestMapping("/delete")
    public String delete(Integer i){
        userDao.delete(i);
        return "hello";
    }
    @RequestMapping("/update")
    public String update(Integer i){
        userDao.update(i);
        return "hello";
    }
    @RequestMapping("/query")
    public String query(){
        userDao.query();
        return "hello";
    }
}
