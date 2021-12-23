package com.laowang.converter;

import com.laowang.bean.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("myConverter")
public class MyConverter implements Converter<String, User> {

    @Override
    public User convert(String source) {
        System.out.println("convert~~~~~~~~~~~~~~~~"+source);
        User user = null;
        if (source != null && !source.trim().equals("")
                && source.split("-").length == 4){
            user = new User();
            String[] split = source.split("-");
            user.setId(Integer.valueOf(split[0]));
            user.setName(split[1]);
            user.setAge(Integer.valueOf(split[2]));
            user.setPassword(split[3]);
        }
        return user;
    }
}
