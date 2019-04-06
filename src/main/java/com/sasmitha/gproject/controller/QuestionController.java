package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.services.QuestionService;
import com.sasmitha.gproject.services.UserServices;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/question")
public class QuestionController extends HttpServlet {

        @Autowired
        private QuestionService questionService;

    @Autowired
    private UserServices userServices;


//    @GetMapping("/data")
//    public ModelAndView saveQuestionDataGet(ModelMap model) {
//        QuestionData questionData=new QuestionData();
//        model.addAttribute("questionData",questionData);
//        return new ModelAndView("QuestionData");
//    }

    @PostMapping("/insertQuestionData")
    public ModelAndView saveQuestionDataPOST(QuestionData questionData, BindingResult result, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session=request.getSession(false);
        String userName = (String) session.getAttribute("loggedUserName");

        int userid=userServices.getuserid(userName);


        int preSetid=questionService.getsetid(userid);

        questionData.setSetID(preSetid+1);
        questionData.setUserID(userid);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
        Date date = new Date();
        String stringDate=dateFormat.format(date); //2016/11/16 12:08:43

            try {
                questionData.setCreatedDate(dateFormat.parse(stringDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        questionData.setQuestionDataID(Integer.parseInt((Integer.toString(userid))+Integer.toString(preSetid+1)));
        questionService.saveQuestionData(questionData);
        return new ModelAndView("successTest");
    }



        @GetMapping("/create")
        public ModelAndView saveQuestionGet(ModelMap model) {
            Question question=new Question();
            model.addAttribute("question",question);
            return new ModelAndView("Question");
        }

        @PostMapping("/insertQuestion")
        public ModelAndView saveQuestionPost(Question question, BindingResult result) {
            questionService.saveQuestion(question);
            return new ModelAndView("redirect:create");
        }
    }
