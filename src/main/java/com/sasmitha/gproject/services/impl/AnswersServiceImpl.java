package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.model.Answers;
import com.sasmitha.gproject.repositories.AnswersRepository;
import com.sasmitha.gproject.services.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AnswersServiceImpl implements AnswersService {

    @Autowired
    private AnswersRepository answersRepository;

    @Override
    public void saveAnswerData(Answers answers) {
        answersRepository.save(answers);
    }
}
