package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT Max(SetID) FROM Question_Data WHERE UserID=:userid",nativeQuery = true)
    int getSetId(@Param("userid") int userid);
}


