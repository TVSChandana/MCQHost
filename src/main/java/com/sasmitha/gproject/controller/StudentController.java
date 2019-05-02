package com.sasmitha.gproject.controller;

import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.Student;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/student")
public class StudentController {

    String loggedStudentName;

    @Autowired
    private StudentService studentService;

    @GetMapping("/Logdata")
    public ModelAndView logGet(ModelMap model){
        Student student=new Student();
        model.addAttribute("student",student);
        return new ModelAndView("login");
    }

    @PostMapping("/register")
    public ModelAndView registerPost(Student student) {
        studentService.saveStudent(student);
        return new ModelAndView("redirect:Logdata");
    }

    @PostMapping("/login")
    public ModelAndView logPost(Student student, ModelMap model, HttpServletRequest request){
        int a=studentService.validStudentData(student.getUsername(),student.getPassword());
        loggedStudentName=student.getUsername();
        if (a==1){

            //           HttpServletRequest request = null;
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUserName", student.getUsername());

            return new ModelAndView("successTest");


        }else{
            return new ModelAndView("successTest");
        }

    }
}
