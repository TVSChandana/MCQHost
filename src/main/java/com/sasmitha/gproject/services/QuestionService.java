package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;

import java.util.List;

public interface QuestionService{
    void saveQuestion(Question question);

    void saveQuestionData(QuestionData questionData);

    List<QuestionData> getLoggedUserQuestioData(String userName);

    int getsetid(int userid);

    int getQuestionDataId(int userid);
}
