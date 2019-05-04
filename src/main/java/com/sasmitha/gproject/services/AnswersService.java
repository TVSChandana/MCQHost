package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.Answers;

import java.util.List;

public interface AnswersService {
    void saveAnswerData(Answers answers);

    List<Answers> getTestData(int g_student_id, int g_question_data_id);


    int getQuestionCount(int g_student_id, int g_question_data_id);

    int getUnAnsweredQuestionNumberCount(int g_student_id, int g_question_data_id);

    int getIncorrectQuestions(int g_student_id, int g_question_data_id);

    int getTotalMarks(int g_student_id, int g_question_data_id);

    int getStudentMarks(int g_student_id, int g_question_data_id);

}
