package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.services.QuestionService;
import com.sasmitha.gproject.services.UserServices;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static javax.swing.JOptionPane.showMessageDialog;


@RestController
@RequestMapping("/question")
public class QuestionController extends HttpServlet {

    int logged_userId;
    int numberOfQuestions;
    int i=1;
    int deleteQuestionId;

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
        logged_userId=userid;

        numberOfQuestions=questionData.getNumberOfQuestions();

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

//        questionData.setQuestionDataID(Integer.parseInt((Integer.toString(userid))+Integer.toString(preSetid+1)));
        questionService.saveQuestionData(questionData);
        return new ModelAndView("redirect:create");
    }



        @GetMapping("/create")
        public ModelAndView saveQuestionGet(ModelMap model) {
            Question question=new Question();

            int questionNumber =i;
            model.addAttribute("questionNumber",questionNumber);

            model.addAttribute("question",question);
            return new ModelAndView("Questions");
        }

        @PostMapping("/insertQuestion")
        public ModelAndView saveQuestionPost(Question question, BindingResult result) {
            if (question.getCorr_Ans_1()==null){
                question.setCorr_Ans_1(0);
            }
            if (question.getCorr_Ans_2()==null){
                question.setCorr_Ans_2(0);
            }
            if (question.getCorr_Ans_3()==null){
                question.setCorr_Ans_3(0);
            }
            if (question.getCorr_Ans_4()==null){
                question.setCorr_Ans_4(0);
            }

            question.setCorrect_Ans(question.getCorr_Ans_1()*1000+question.getCorr_Ans_2()*100+question.getCorr_Ans_3()*10+question.getCorr_Ans_4());

            int oo=questionService.getQuestionDataId(logged_userId);

            question.setQuestion_Data_Id(questionService.getQuestionDataId(logged_userId));


            question.setQuestion_Number(i);
            i++;


            questionService.saveQuestion(question);

            if(i==numberOfQuestions+1){
                i=1;
                return new ModelAndView("redirect:http://localhost:8080/user/logSuccess");
//                RedirectView rv = new RedirectView();
//                rv.setUrl("http://localhost:8080/user/logSuccess");
//                return rv;
            }else{
                return new ModelAndView("redirect:create");
//                RedirectView rv = new RedirectView();
//                rv.setUrl("/question/create");
//                return rv;
            }


        }

        @GetMapping("/view/{questionDataID}")
        public ModelAndView viewQuestions(@PathVariable Integer questionDataID,ModelMap model){
            ArrayList<Question> array=new ArrayList<>();
            array=questionService.viewAllQuestions(questionDataID);
            model.addAttribute("arr",array);
            return new ModelAndView("viewQuestions");

        }

    @GetMapping("/delete/{questionDataID}")
    public ModelAndView confirmDeleteQuestions(@PathVariable Integer questionDataID,ModelMap model){
        deleteQuestionId=questionDataID;
        User user=new User();
        model.addAttribute("user",user);
        return new ModelAndView("confirm");

    }

    @PostMapping("/delete")
    public ModelAndView deleteQuestions(ModelMap model,User user,HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(false);
        String userName = (String) session.getAttribute("loggedUserName");
        int userId=userServices.getuserid(userName);

        String pass=user.getPassword();

        int value=userServices.getConfermation(pass,userId);

        if (value>0) {
            questionService.deleteQuestionData(deleteQuestionId);
            //questionService.deleteQuestion(questionDataID);
        }

        return new ModelAndView("redirect:http://localhost:8080/user/logSuccess");

    }
    }
