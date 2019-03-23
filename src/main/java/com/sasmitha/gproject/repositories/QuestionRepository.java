package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
}


