package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/user2")
public class UserController2 {

    /*
    * 处理请求包含的对象，入参User user自动接收对象
    * 地址栏：context 也行，context/index.jsp 都行
    * 问题来了，请求对象是怎么传入方法的呢？？？
    * */
    @RequestMapping("/test1")
    public String handleUser1(User user){
        System.out.println(user);
        return "success";
    }

    /*
    * controller  ，Spring MVC 支持原生 servlet的对象，可以从参数中获取！
    * HttpServletRequest
    * HttpServletResponse
    * HttpSession
    * Locale 设置区域信息 ，国际化时候用到这东西！
    * InputStream 从请求中获得
    * OutputStream 从响应中生成
    * Reader
    * Writer
    * */
    @RequestMapping("api")
    public String api(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                      Locale locale){
        request.setAttribute("request","This is REQUEST!");
        session.setAttribute("session","This is SESSION!");
        return "success";
    }
}
