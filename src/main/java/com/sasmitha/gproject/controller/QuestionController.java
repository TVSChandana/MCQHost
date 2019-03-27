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

@RestController
//@RequestMapping("/question")
public class QuestionController {

        @Autowired
        private QuestionService questionService;


    @GetMapping("/data")
    public ModelAndView saveQuestionDataGet(ModelMap model) {
        QuestionData questionData=new QuestionData();
        model.addAttribute("questionData",questionData);
        return new ModelAndView("QuestionData");
    }

    @PostMapping("/insertQuestionData")
    public ModelAndView saveQuestionDataPOST(QuestionData questionData, BindingResult result) {
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
