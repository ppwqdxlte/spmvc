package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/i18n")
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/1")
    public String i18n1(Locale locale,User user){
        System.out.println("i18n 1 controller......");System.out.println(locale);System.out.println(user);
        String username = messageSource.getMessage("username", null, locale);
        System.out.println(username);
        return "forward:/login.jsp";
    }

    /*
    * 请求 静态资源/index.jsp 被defaultServletHandler过滤掉了，没经过前端控制器的localeResolver步骤，所以无法国际化；
    * 但是经过前端控制器过滤的动态请求，经过了国际化处理器， 自定义的 LocaleResolver就能生效了
    * */
    @RequestMapping("/2")
    public String i18n2(@RequestParam("locale") String loc, Locale locale, HttpServletResponse response){
        System.out.println("Handle my locale request....");
        System.out.println(loc);
        System.out.println(locale);
        response.setLocale(locale);
        return "success";
    }

    /*不推荐在controller方法中写国际化代码，冗余太多，还是自定义LocaleResolver更好点，
    除了实现LocaleResolver接口，还可以继承CookieLocaleResolver，SessionLocaleResolver等等
    * */
    @RequestMapping("/3")
    public String i18n3(@RequestParam(value = "locale",required = false) String locStr,Locale locale ,HttpSession session){
        Locale locale1 = null;
        if (locStr!=null && !"".equals(locStr) && locStr.split("-").length==2){
            locale1 = new Locale(locStr.split("-")[0],locStr.split("-")[1]);
        }else{
            locale1 = locale;
        }
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);
        return "success";
    }
}
