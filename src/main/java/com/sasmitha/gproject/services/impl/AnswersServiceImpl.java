package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.model.Answers;
import com.sasmitha.gproject.repositories.AnswersRepository;
import com.sasmitha.gproject.services.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswersServiceImpl implements AnswersService {

    @Autowired
    private AnswersRepository answersRepository;

    @Override
    public void saveAnswerData(Answers answers) {
        answersRepository.save(answers);
    }

    @Override
    public List<Answers> getTestData(int g_student_id, int g_question_data_id) {
        return answersRepository.getTestdata(g_student_id,g_question_data_id);
    }

    @Override
    public int getQuestionCount(int g_student_id, int g_question_data_id) {
        return answersRepository.getQuestionCount(g_student_id,g_question_data_id);
    }

    @Override
    public int getUnAnsweredQuestionNumberCount(int g_student_id, int g_question_data_id) {
        return answersRepository.getUnAnsweredQuestionNumberCount(g_student_id,g_question_data_id);
    }

    @Override
    public int getIncorrectQuestions(int g_student_id, int g_question_data_id) {
        return answersRepository.getIncorrectQuestions(g_student_id,g_question_data_id);
    }

    @Override
    public int getTotalMarks(int g_student_id, int g_question_data_id) {
        return  answersRepository.getTotalMarks(g_student_id,g_question_data_id);
    }

    @Override
    public int getStudentMarks(int g_student_id, int g_question_data_id) {
        return answersRepository.getStudentMarks(g_student_id,g_question_data_id);
    }


}
