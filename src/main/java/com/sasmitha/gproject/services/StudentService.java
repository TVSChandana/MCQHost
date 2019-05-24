package com.sasmitha.gproject.services;

import com.sasmitha.gproject.additionalClasses.StudentRequestData;
import com.sasmitha.gproject.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);

    int validStudentData(String username, String password);

    int countStudents();

    int getStudentId(String loggedStudentName);

    List<StudentRequestData> getStudentFollowerData(int i, int loggedUserId);

    String getStudentFullName(int g_student_id);
}
