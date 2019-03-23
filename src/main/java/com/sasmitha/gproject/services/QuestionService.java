package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;

public interface QuestionService{
    void saveQuestion(Question question);

    void saveQuestionData(QuestionData questionData);
}
