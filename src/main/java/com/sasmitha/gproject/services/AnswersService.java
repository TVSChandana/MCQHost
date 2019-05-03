package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.Answers;

import java.util.List;

public interface AnswersService {
    void saveAnswerData(Answers answers);

    List<Answers> getTestData(int g_student_id, int g_question_data_id);


}
