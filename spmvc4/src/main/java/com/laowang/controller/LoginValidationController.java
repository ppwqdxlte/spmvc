package com.laowang.controller;

import com.laowang.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/validate")
public class LoginValidationController {

    @RequestMapping("/1")
    public String login1(@Valid Person person, BindingResult bindingResult, Model model){
        System.out.println(person);
        if (bindingResult.hasFieldErrors()){
            Map<String,Object> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError);
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("person",person);
            return "forward:/login.jsp";
        }else {
            return "forward:/index.jsp";

        }
    }
}
