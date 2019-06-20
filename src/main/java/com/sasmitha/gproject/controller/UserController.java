package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.additionalClasses.RequestData;
import com.sasmitha.gproject.additionalClasses.StudentRequestData;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.Request;
import com.sasmitha.gproject.model.Student;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.services.QuestionService;
import com.sasmitha.gproject.services.RequestService;
import com.sasmitha.gproject.services.StudentService;
import com.sasmitha.gproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController extends HttpServlet {

    int zeroIndex;
    String loggedUserName;
    String loggedStudentName;
    int selectedUserId;
    int divStatus;


    @Autowired
    private UserServices userServices;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private StudentService studentService;


    @Autowired
    private RequestService requestService;
//    @GetMapping("/data")
//    public ModelAndView registerGet(ModelMap model) {
//        User user=new User();
//        model.addAttribute("user",user);
//        return new ModelAndView("user");
//    }

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

        return new ModelAndView("redirect:Logdata");
    }

    @PostMapping("/studentRegister")
    public ModelAndView studentRegisterPost(Student student) {
        studentService.saveStudent(student);
        int regStudentId=studentService.getStudentId(student.getUsername());
        Request request=new Request();
        request.setAdmin_Id(0);
        request.setRequest_status(0);
        request.setStudent_Id(regStudentId);

        requestService.saveRequest(request);

        return new ModelAndView("redirect:Logdata");
    }

    @GetMapping("/Logdata")
    public ModelAndView logGet(ModelMap model){
    User user=new User();
    model.addAttribute("user",user);

    Student student=new Student();
    model.addAttribute("student",student);

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


    @PostMapping("/studentLogin")
    public ModelAndView studentLogPost(Student student,HttpServletRequest request){
        int a=studentService.validStudentData(student.getUsername(),student.getPassword());
        loggedStudentName=student.getUsername();
        if (a==1){
            HttpSession studentSession = request.getSession(true);
            studentSession.setAttribute("loggedStudentName",student.getUsername());
            return new ModelAndView("redirect:studentLogSuccess");
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


    @GetMapping("/studentLogSuccess")
    public ModelAndView studentLogSuccess(ModelMap model){
    int userCount=studentService.countStudents()+userServices.countUsers();
    model.addAttribute("userCount",userCount);

    User user=new User();
    model.addAttribute("user",user);

//    List<Request> list=new LinkedList<Request>();
//    list=requestService.getRequestData();
//
//        List<Request> pendinglist=new LinkedList<Request>();
//        List<Request> acceptedlist=new LinkedList<Request>();
//    for(int i=0;i<list.size();i++){
//
//        if(list.get(i).getRequest_status()==1){
//           pendinglist.add(list.get(i));
//        }else if(list.get(i).getRequest_status()==2){
//            acceptedlist.add(list.get(i));
//        }else{
//
//        }
//    }
//
//    model.addAttribute("pendinglist",pendinglist);
//    model.addAttribute("acceptedlist",acceptedlist);
//    model.addAttribute("pendinglistSize",pendinglist.size());
//    model.addAttribute("acceptedlistSize",acceptedlist.size());


         divStatus=0;
        model.addAttribute("divStatus",divStatus);

        int loggedStudentId=studentService.getStudentId(loggedStudentName);

        List<RequestData> pendinglist=new LinkedList<RequestData>();
        pendinglist=userServices.getRequestData(1,loggedStudentId);


        List<RequestData> acceptedlist=new LinkedList<RequestData>();
        acceptedlist=userServices.getRequestData(2,loggedStudentId);


    model.addAttribute("pendinglist",pendinglist);
    model.addAttribute("acceptedlist",acceptedlist);
    model.addAttribute("pendinglistSize",pendinglist.size());
    model.addAttribute("acceptedlistSize",acceptedlist.size());
    return new ModelAndView("StudentPage");

    }

    @PostMapping("/search")
    public ModelAndView userSearch(User user,ModelMap model){
        int i=userServices.getuserid(user.getUsername());
        User suser=new User();
        suser=userServices.search(i);
        selectedUserId=suser.getId();
        String name=suser.getFirstName()+" "+suser.getLastName();
        model.addAttribute("name",name);

        String occupationData=suser.getOccupationData();
        model.addAttribute("occupationData",occupationData);



        int loggedStudentId=studentService.getStudentId(loggedStudentName);

        List<RequestData> pendinglist=new LinkedList<RequestData>();
        pendinglist=userServices.getRequestData(1,loggedStudentId);


        List<RequestData> acceptedlist=new LinkedList<RequestData>();
        acceptedlist=userServices.getRequestData(2,loggedStudentId);


        model.addAttribute("pendinglist",pendinglist);
        model.addAttribute("acceptedlist",acceptedlist);
        model.addAttribute("pendinglistSize",pendinglist.size());
        model.addAttribute("acceptedlistSize",acceptedlist.size());


        divStatus=1;
        model.addAttribute("divStatus",divStatus);

        return new ModelAndView("StudentPage");
    }
    @GetMapping("/follow")
    public ModelAndView Follow(ModelMap model){
        int loggedStudentId=studentService.getStudentId(loggedStudentName);
        Request request=new Request();
        request.setStudent_Id(loggedStudentId);
        request.setAdmin_Id(selectedUserId);
        request.setRequest_status(1);

        requestService.saveRequest(request);

        User user=new User();
        model.addAttribute("user",user);


        List<RequestData> pendinglist=new LinkedList<RequestData>();
        pendinglist=userServices.getRequestData(1,loggedStudentId);


        List<RequestData> acceptedlist=new LinkedList<RequestData>();
        acceptedlist=userServices.getRequestData(2,loggedStudentId);

        model.addAttribute("pendinglist",pendinglist);
        model.addAttribute("acceptedlist",acceptedlist);
        model.addAttribute("pendinglistSize",pendinglist.size());
        model.addAttribute("acceptedlistSize",acceptedlist.size());

        divStatus=0;
        model.addAttribute("divStatus",divStatus);


        return new ModelAndView("StudentPage");

    }

    @GetMapping("/cancelRequest/{Request_Id}")
    public ModelAndView cancelRequest(@PathVariable Integer Request_Id,ModelMap model){



        int loggedStudentId=studentService.getStudentId(loggedStudentName);
        List<RequestData> pendinglist=new LinkedList<RequestData>();
        pendinglist=userServices.getRequestData(1,loggedStudentId);


        List<RequestData> acceptedlist=new LinkedList<RequestData>();
        acceptedlist=userServices.getRequestData(2,loggedStudentId);

        model.addAttribute("pendinglist",pendinglist);
        model.addAttribute("acceptedlist",acceptedlist);
        model.addAttribute("pendinglistSize",pendinglist.size());
        model.addAttribute("acceptedlistSize",acceptedlist.size());

        requestService.cancelRequest(Request_Id);

        divStatus=0;
        model.addAttribute("divStatus",divStatus);

        User user=new User();
        model.addAttribute("user",user);

        return new ModelAndView("StudentPage");
    }

    @GetMapping("/followereManage")
    public ModelAndView cancelRequest(ModelMap model){

        int loggedUserId=userServices.getuserid(loggedUserName);
        List<StudentRequestData> pendinglist=new LinkedList<StudentRequestData>();
        pendinglist=studentService.getStudentFollowerData(1,loggedUserId);


        List<StudentRequestData> acceptedlist=new LinkedList<StudentRequestData>();
        acceptedlist=studentService.getStudentFollowerData(2,loggedUserId);

        model.addAttribute("pendinglist",pendinglist);
        model.addAttribute("acceptedlist",acceptedlist);
        model.addAttribute("pendinglistSize",pendinglist.size());
        model.addAttribute("acceptedlistSize",acceptedlist.size());


        return new ModelAndView("UserFollowerMangePage");
    }

    @GetMapping("/AcceptFollowerRequest/{Request_Id}")
    public ModelAndView AcceptFollowerRequest(@PathVariable Integer Request_Id,ModelMap model){
        Request str=new Request();
        str= requestService.getOldStudentRequestData(Request_Id);
        str.setRequest_status(2);
        requestService.acceptRequest(str);


        int loggedUserId=userServices.getuserid(loggedUserName);
        List<StudentRequestData> pendinglist=new LinkedList<StudentRequestData>();
        pendinglist=studentService.getStudentFollowerData(1,loggedUserId);


        List<StudentRequestData> acceptedlist=new LinkedList<StudentRequestData>();
        acceptedlist=studentService.getStudentFollowerData(2,loggedUserId);

        model.addAttribute("pendinglist",pendinglist);
        model.addAttribute("acceptedlist",acceptedlist);
        model.addAttribute("pendinglistSize",pendinglist.size());
        model.addAttribute("acceptedlistSize",acceptedlist.size());

        return new ModelAndView("UserFollowerMangePage");
    }

}


