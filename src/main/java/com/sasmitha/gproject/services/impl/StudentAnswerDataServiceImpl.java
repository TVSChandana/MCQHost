package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.model.StudentAnswerData;
import com.sasmitha.gproject.repositories.StudentAnswerDataRepository;
import com.sasmitha.gproject.services.StudentAnswerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAnswerDataServiceImpl implements StudentAnswerDataService {

    @Autowired
    private StudentAnswerDataRepository studentAnswerDataRepository;

    @Override
    public void saveStudentData(StudentAnswerData sadata) {
        studentAnswerDataRepository.save(sadata);
    }

    @Override
    public List<StudentAnswerData> getStudentAnswersData(Integer questionDataID) {
        return studentAnswerDataRepository.getStudentAnswersData(questionDataID);
    }

    @Override
    public int getStudentTestStatusCount(int g_student_id, int selectedQuestionDataId) {
        return studentAnswerDataRepository.getStudentTestStatusCount(g_student_id,selectedQuestionDataId);
    }
}
