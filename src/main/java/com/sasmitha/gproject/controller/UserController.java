package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.services.QuestionService;
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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends HttpServlet {

    int zeroIndex;
    String loggedUserName;

    @Autowired
    private UserServices userServices;

    @Autowired
    private QuestionService questionService;


    @GetMapping("/data")
    public ModelAndView registerGet(ModelMap model) {
        User user=new User();
        model.addAttribute("user",user);
        return new ModelAndView("user");
    }

    @PostMapping("/register")
    public ModelAndView registerPost(User user) {
            userServices.saveUser(user);

            //create an test data  with set id '0'
            QuestionData qd=new QuestionData();
            qd.setCreatedDate(null);
            qd.setUserID(userServices.getuserid(user.getUsername()));
            qd.setSetID(0);
            qd.setQuestionDataID(0);
            qd.setNumberOfQuestions(0);
            qd.setTestName(null);
            qd.setTestType(null);

            questionService.saveQuestionData(qd);
            //

        return new ModelAndView("redirect:data");
    }

    @GetMapping("/Logdata")
    public ModelAndView logGet(ModelMap model){
    User user=new User();
    model.addAttribute("user",user);
    return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView logPost(User user,ModelMap model,HttpServletRequest request){
       int a=userServices.validUserData(user.getUsername(),user.getPassword());
        loggedUserName=user.getUsername();
       if (a==1){

           //           HttpServletRequest request = null;
           HttpSession session = request.getSession(true);
           session.setAttribute("loggedUserName", user.getUsername());

           return new ModelAndView("redirect:logSuccess");


       }else{
           return new ModelAndView("successTest");
       }

    }

    @GetMapping("/logSuccess")
    public ModelAndView logSuccess(ModelMap model){

        QuestionData questionData=new QuestionData();
        model.addAttribute("questionData",questionData);

        List<QuestionData> list=new LinkedList<QuestionData>();
        list=questionService.getLoggedUserQuestioData(loggedUserName);
        model.addAttribute("list",list);



        int result=list.size()-1;

        for(int i=0;i<=result;i++){
            if(list.get(i).getSetID()==0){
                zeroIndex=i;
            }
        }

        list.remove(zeroIndex);

        model.addAttribute("results",result);


        return new ModelAndView("QuestionData");

    }
}
