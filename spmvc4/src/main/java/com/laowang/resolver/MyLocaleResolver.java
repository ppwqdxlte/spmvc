package com.laowang.resolver;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Order(2)
public class MyLocaleResolver implements LocaleResolver {

    private Locale locale;

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String localeStr = request.getParameter("locale");
        System.out.println(this.getClass().getName()+"===resolveLocale===>>>>     "+localeStr);
        if (localeStr != null && !"".equals(localeStr)){
            locale = new Locale(localeStr.split("-")[0],localeStr.split("-")[1]);
        } else {
            locale = request.getLocale();
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException("/////////I don't know what it is either...//////////////");
    }
}
