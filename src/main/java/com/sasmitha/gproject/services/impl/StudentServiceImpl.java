package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.additionalClasses.StudentRequestData;
import com.sasmitha.gproject.model.Student;
import com.sasmitha.gproject.repositories.StudentRepository;
import com.sasmitha.gproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
     studentRepository.save(student);
    }

    @Override
    public int validStudentData(String username, String password) {
       return studentRepository.getUserAvailability(username, password);
    }

    @Override
    public int countStudents() {
        return studentRepository.countStudents();
    }

    @Override
    public int getStudentId(String loggedStudentName) {
        return studentRepository.getstudentId(loggedStudentName);
    }

    @Override
    public List<StudentRequestData> getStudentFollowerData(int i, int loggedUserId) {
        return studentRepository.getStudentFollowerData(i,loggedUserId);
    }

    @Override
    public String getStudentFullName(int g_student_id) {
        return studentRepository.getStudentFirstName(g_student_id)+" "+studentRepository.getStudentLastName(g_student_id);
    }
}
