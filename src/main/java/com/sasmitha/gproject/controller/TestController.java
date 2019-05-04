package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.Answers;
import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    int zeroIndex;
    int selectedQuestionDataId;
    int arraySize;
    int pivot=0;

//Answers object variables--------

    int G_Student_Id;
    int G_Question_Data_Id;
    int G_Question_Id;
    int G_Question_Number;
    String G_Quest;
    String G_Ans_1;
    String G_Ans_2;
    String G_Ans_3;
    String G_Ans_4;
    int G_Corr_Ans_1;
    int G_Corr_Ans_2;
    int G_Corr_Ans_3;
    int G_Corr_Ans_4;
    int G_Stud_Ans_1;
    int G_Stud_Ans_2;
    int G_Stud_Ans_3;
    int G_Stud_Ans_4;
    int G_mark;
    int G_Answer_Status;
    int G_Student_mark;


    @Autowired
    private UserServices userServices;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private StudentService studentService;


    @Autowired
    private RequestService requestService;

    @Autowired
    private AnswersService answersService;

    @GetMapping("/view/{Admin_Id}")
    public ModelAndView logGet(@PathVariable Integer Admin_Id, ModelMap model){

        String adminUserName=userServices.getAdminUserName(Admin_Id);

        QuestionData questionData=new QuestionData();
        model.addAttribute("questionData",questionData);

        List<QuestionData> list=new LinkedList<QuestionData>();
        list=questionService.getLoggedUserQuestioData(adminUserName);
        model.addAttribute("list",list);



        int result=list.size()-1;

        for(int i=0;i<=result;i++){
            if(list.get(i).getSetID()==0){
                zeroIndex=i;
            }
        }

        list.remove(zeroIndex);

        model.addAttribute("results",result);


        return new ModelAndView("QuestionDataStudentView");
    }


    @PostMapping("/try")
    public ModelAndView viewQuestions(QuestionData questionData, ModelMap model, HttpServletRequest request, HttpServletResponse response){
        String a=questionData.getTest_Password();
        String b=questionService.getQuestionData(questionData.getQuestionDataID()).getTest_Password();
        selectedQuestionDataId=questionData.getQuestionDataID();

        HttpSession session=request.getSession(false);
        String StudentName = (String) session.getAttribute("loggedStudentName");
        int studentId=studentService.getStudentId(StudentName);
        G_Student_Id=studentId;


        if(a.equals(b)){
            return new ModelAndView("redirect:map");
        }else{
            return new ModelAndView("redirect:map");
        }

    }

    @GetMapping("/map")
    public ModelAndView markGet( ModelMap model){

        ArrayList<Question> array=new ArrayList<>();
        array=questionService.viewAllQuestions(selectedQuestionDataId);

        arraySize=array.size();

        if(pivot==arraySize){
            pivot=0;
            return new ModelAndView("redirect:answerViwe");
        }else{


            int qn=array.get(pivot).getQuestion_Number();
            String ques=array.get(pivot).getQuest();
            String ans1=array.get(pivot).getAns_1();
            String ans2=array.get(pivot).getAns_2();
            String ans3=array.get(pivot).getAns_3();
            String ans4=array.get(pivot).getAns_4();

            model.addAttribute("qn",qn);
            model.addAttribute("ques",ques);
            model.addAttribute("ans1",ans1);
            model.addAttribute("ans2",ans2);
            model.addAttribute("ans3",ans3);
            model.addAttribute("ans4",ans4);


            G_Question_Data_Id=array.get(pivot).getQuestion_Data_Id();
            G_Question_Id=array.get(pivot).getQuestion_ID();
            G_Question_Number=array.get(pivot).getQuestion_Number();
            G_Quest=array.get(pivot).getQuest();
            G_Ans_1=array.get(pivot).getAns_1();
            G_Ans_2=array.get(pivot).getAns_2();
            G_Ans_3=array.get(pivot).getAns_3();
            G_Ans_4=array.get(pivot).getAns_4();
            G_Corr_Ans_1=array.get(pivot).getCorr_Ans_1();
            G_Corr_Ans_2=array.get(pivot).getCorr_Ans_2();
            G_Corr_Ans_3=array.get(pivot).getCorr_Ans_3();
            G_Corr_Ans_4=array.get(pivot).getCorr_Ans_4();
            G_mark=array.get(pivot).getMark();

//            G_Answer_Status
//            G_Student_mark


            Question question=new Question();
            model.addAttribute("question",question);
            pivot++;
            return new ModelAndView("Test");
        }

    }

    @PostMapping("/mark")
    public ModelAndView markPost(Question question, ModelMap model){

        Answers answers=new Answers();
        answers.setStudent_Id(G_Student_Id);
        answers.setQuestion_Data_Id(G_Question_Data_Id);
        answers.setQuestion_Id(G_Question_Id);
        answers.setQuestion_Number(G_Question_Number);

        answers.setQuest(G_Quest);
        answers.setAns_1(G_Ans_1);
        answers.setAns_2(G_Ans_2);
        answers.setAns_3(G_Ans_3);
        answers.setAns_4(G_Ans_4);

        answers.setCorr_Ans_1(G_Corr_Ans_1);
        answers.setCorr_Ans_2(G_Corr_Ans_2);
        answers.setCorr_Ans_3(G_Corr_Ans_3);
        answers.setCorr_Ans_4(G_Corr_Ans_4);

        answers.setStud_Ans_1(question.getCorr_Ans_1());
        answers.setStud_Ans_2(question.getCorr_Ans_2());
        answers.setStud_Ans_3(question.getCorr_Ans_3());
        answers.setStud_Ans_4(question.getCorr_Ans_4());

        answers.setMark(G_mark);

        if (answers.getStud_Ans_1()==null){
            answers.setStud_Ans_1(0);
        }
        if (answers.getStud_Ans_2()==null){
            answers.setStud_Ans_2(0);
        }
        if (answers.getStud_Ans_3()==null){
            answers.setStud_Ans_3(0);
        }
        if (answers.getStud_Ans_4()==null){
            answers.setStud_Ans_4(0);
        }

        if(answers.getStud_Ans_1()==0 && answers.getStud_Ans_2()==0 && answers.getStud_Ans_3()==0  && answers.getStud_Ans_4()==0){
         answers.setAnswered_Or_Not("Not Answered");
        }else{
            answers.setAnswered_Or_Not("Answered");
        }

        if(answers.getStud_Ans_1()==G_Corr_Ans_1 && answers.getStud_Ans_2()==G_Corr_Ans_2 && answers.getStud_Ans_3()==G_Corr_Ans_3  && answers.getStud_Ans_4()==G_Corr_Ans_4  )
        {
            answers.setAnswer_Status(1);
            answers.setStudent_mark(answers.getMark());
        }else {
            answers.setAnswer_Status(0);
            answers.setStudent_mark(0);
        }

        answersService.saveAnswerData(answers);

        return new ModelAndView("redirect:map");
    }


    @GetMapping("/answerViwe")
    public ModelAndView answerView( ModelMap model){
        List<Answers> list=new LinkedList<Answers>();
        list=answersService.getTestData(G_Student_Id,G_Question_Data_Id);
        model.addAttribute("list",list);
        return new ModelAndView("AnswerSummary");
    }

    @GetMapping("/viewMarks")
    public ModelAndView viewMarks( ModelMap model){
        List<Answers> list=new LinkedList<Answers>();
        list=answersService.getTestData(G_Student_Id,G_Question_Data_Id);
        model.addAttribute("list",list);

        int numberOfQuestions=answersService.getQuestionCount(G_Student_Id,G_Question_Data_Id);
        int unAnsweredQuestions=answersService.getUnAnsweredQuestionNumberCount(G_Student_Id,G_Question_Data_Id);
        int incorrectQuestions=answersService.getIncorrectQuestions(G_Student_Id,G_Question_Data_Id);
        int totalMarks=answersService.getTotalMarks(G_Student_Id,G_Question_Data_Id);
        int studentMarks=answersService.getStudentMarks(G_Student_Id,G_Question_Data_Id);

        model.addAttribute("numberOfQuestions",numberOfQuestions);
        model.addAttribute("unAnsweredQuestions",unAnsweredQuestions);
        model.addAttribute("incorrectQuestions",incorrectQuestions);
        model.addAttribute("totalMarks",totalMarks);
        model.addAttribute("studentMarks",studentMarks);

        return new ModelAndView("ViewMarks");
    }
}
