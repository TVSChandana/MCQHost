package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.StudentAnswerData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentAnswerDataService {
    void saveStudentData(StudentAnswerData sadata);

    List<StudentAnswerData> getStudentAnswersData(Integer questionDataID);

}
