package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/data")
    public ModelAndView registerGet(ModelMap model) {
        User user=new User();
        model.addAttribute("user",user);
        return new ModelAndView("user");
    }

    @PostMapping("/register")
    public ModelAndView registerPost(User user) {
            userServices.saveUser(user);
        return new ModelAndView("redirect:data");
    }

    @GetMapping("/Logdata")
    public ModelAndView logGet(ModelMap model){
    User user=new User();
    model.addAttribute("user",user);
    return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView logPost(User user){
       int a=userServices.validUserData(user.getUsername(),user.getPassword());
       if (a==1){
           return new ModelAndView("login");
       }else{
           return new ModelAndView("SuccessTest");
       }

    }
}
