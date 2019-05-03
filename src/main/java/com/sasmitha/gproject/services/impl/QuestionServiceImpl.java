package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.repositories.QuestionDataRepository;
import com.sasmitha.gproject.repositories.QuestionRepository;
import com.sasmitha.gproject.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionDataRepository questionDataRepository;

    @Override
    public void saveQuestion(Question question){
      questionRepository.save(question);
    }

    @Override
    public void saveQuestionData(QuestionData questionData) {
        questionDataRepository.save(questionData);

    }

    @Override
    public List<QuestionData> getLoggedUserQuestioData(String userName) {
        List<QuestionData> list=questionDataRepository.getLoggedUserQuestioData(userName);
        return list;

    }

    @Override
    public int getsetid(int userid) {
        return questionRepository.getSetId(userid);
    }

    @Override
    public int getQuestionDataId(int userid) {
    return questionRepository.getQuestionDataId(userid);
    }

    @Override
    public ArrayList<Question> viewAllQuestions(Integer questionDataID) {
       return questionRepository.viewAllQuestions(questionDataID);
    }

    @Override
    public void deleteQuestion(Integer questionDataID) {
       questionRepository.deleteAllQuestions(questionDataID);

    }

    @Override
    public void deleteQuestionData(Integer questionDataID) {
        questionDataRepository.deleteById(questionDataID);
    }

    @Override
    public QuestionData getQuestionData(Integer questionDataID) {
        return questionDataRepository.getOne(questionDataID);
    }


}
