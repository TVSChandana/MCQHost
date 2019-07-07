package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.QuestionDataStatus;

import java.util.ArrayList;
import java.util.List;

public interface QuestionService{
    void saveQuestion(Question question);

    void saveQuestionData(QuestionData questionData);

    List<QuestionData> getLoggedUserQuestioData(String userName);

    List<QuestionDataStatus> getLoggedUserQuestionDataAndStatus(String userName);

    int getsetid(int userid);

    int getQuestionDataId(int userid);

    ArrayList<Question> viewAllQuestions(Integer questionDataID);


    void deleteQuestion(Integer questionDataID);

    void deleteQuestionData(Integer questionDataID);

    QuestionData getQuestionData(Integer questionDataID);
}
