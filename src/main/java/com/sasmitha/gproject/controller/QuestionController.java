package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.services.QuestionService;
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
import java.util.LinkedList;
import java.util.List;



@RestController
@RequestMapping("/question")
public class QuestionController extends HttpServlet {

        @Autowired
        private QuestionService questionService;


//    @GetMapping("/data")
//    public ModelAndView saveQuestionDataGet(ModelMap model) {
//        QuestionData questionData=new QuestionData();
//        model.addAttribute("questionData",questionData);
//        return new ModelAndView("QuestionData");
//    }

    @PostMapping("/insertQuestionData")
    public ModelAndView saveQuestionDataPOST(QuestionData questionData, BindingResult result, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session=request.getSession(false);
        String userName = (String) session.getAttribute("uName");
        questionData.setQuestionDataID(Integer.parseInt(questionData.getUserID().toString()+questionData.getSetID().toString()));
        questionService.saveQuestionData(questionData);
        return new ModelAndView("redirect:data");
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
