package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.QuestionData;
import com.sasmitha.gproject.model.QuestionDataStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDataRepository extends JpaRepository<QuestionData,Integer> {

    @Query(value = "select q.Question_DataID,q.Number_Of_Questions,q.SetID,q.Test_Name,q.UserID,q.Created_Date,q.Test_Type,q.Test_Password,0 As  FROM User_Table u Inner Join Question_Data q ON u.ID=q.UserID where username=:username",nativeQuery = true)
    List<QuestionDataStatus> getLoggedUserQuestionDataAndStatus(@Param("username") String userName);

    @Query(value = "select q.Question_DataID,q.Number_Of_Questions,q.SetID,q.Test_Name,q.UserID,q.Created_Date,q.Test_Type,q.Test_Password FROM User_Table u Inner Join Question_Data q ON u.ID=q.UserID where username=:username",nativeQuery = true)
    List<QuestionData> getLoggedUserQuestioData(@Param("username") String userName);

    @Query(value = "Delete FROM Question_Data WHERE Question_DataID=:questionDataID",nativeQuery = true)
    void deleteQuestionData(@Param("questionDataID") Integer questionDataID);

}

