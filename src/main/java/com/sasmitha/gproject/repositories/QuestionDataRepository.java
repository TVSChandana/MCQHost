package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.QuestionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDataRepository extends JpaRepository<QuestionData,Integer> {

    @Query(value = "select q.Question_DataID,q.Number_Of_Questions,q.SetID,q.Test_Name,q.UserID,q.Created_Date FROM User_Table u Inner Join Question_Data q ON u.ID=q.UserID where username=:username",nativeQuery = true)
    List<QuestionData> getLoggedUserQuestioData(@Param("username") String userName);


}

