package com.laowang.controller;

import com.laowang.bean.User;
import com.laowang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ucr")
public class UserController_RESTFUL {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String save(){
        User user = new User();
        userDao.save(user);
        return "success";
    }
    /*  对于DELETE的方法：
       【注意】如果直接转发到目标视图，那么就会报这种错误：
    * HTTP状态 405 - 方法不允许
    * 消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS
    * 描述 请求行中接收的方法由源服务器知道，但目标资源不支持

        所以重定向到别的方法，迂回返回目标视图
    * */
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String delete(Integer i){
        userDao.delete(i);
        return "redirect:/ucr/todel";
    }
    @RequestMapping("/todel")
    public String todel(){
        return "success";
    }
    /*  对于PUT的方法：
       【注意】如果直接转发到目标视图，那么就会报这种错误：
    * HTTP状态 405 - 方法不允许
    * 消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS
    * 描述 请求行中接收的方法由源服务器知道，但目标资源不支持

        所以重定向到别的方法，迂回返回目标视图
    * */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String update(Integer i){
        userDao.update(i);
        return "redirect:/ucr/toput";
    }
    @RequestMapping("/toput")
    public String toput(){
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String query(){
        userDao.query();
        return "success";
    }
}
