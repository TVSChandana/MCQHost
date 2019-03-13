package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.MyModel;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

     @Autowired
     private UserServices userServices;

//    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
//    public  String sayHello(){
//        myModel.setName("welcome gradle");
//        return "welcome";
//    }


    @GetMapping("/insert")
    public ModelAndView user(ModelMap model){
      User user=new User();
        List<User> list=new LinkedList<User>();
        list= userServices.findAllUsers();
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        return new ModelAndView("user");


    }

    @PostMapping("/insert")
    public ModelAndView insertuser(User user, BindingResult result){
        if(user.getId()==null){
                userServices.saveUser(user);
            }else{
                userServices.updateUser(user);
            }
        return new ModelAndView("redirect:insert");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(ModelMap model,@PathVariable Integer id){
        userServices.deleteUser(id);


        User user=new User();
        List<User> list=new LinkedList<User>();
        list=userServices.findAllUsers();
        model.addAttribute("list",list);
        model.addAttribute("user",user);
        return new ModelAndView("user");
    }




    @GetMapping("/update/{id}")
    public ModelAndView updateUser(User user,ModelMap model,@PathVariable Integer id){
        User userdata=new User();
        userdata=userServices.getUseById(id);
        model.addAttribute("user",userdata);

        List<User> list=new LinkedList<User>();
        list=userServices.findAllUsers();
        model.addAttribute("list",list);
        return new ModelAndView("user");
    }


}
