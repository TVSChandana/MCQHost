package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.Question;
import com.sasmitha.gproject.model.QuestionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query(value = "SELECT Max(SetID) FROM Question_Data WHERE UserID=:userid",nativeQuery = true)
    int getSetId(@Param("userid") int userid);

    @Query(value = "SELECT Question_DataID FROM Question_Data WHERE UserID=:userid and SetID=(select max(SetID) from question_data where UserID=userid) ",nativeQuery = true)
    int getQuestionDataId(@Param("userid") int userid);

    @Query(value = "SELECT * FROM Question WHERE Question_Data_Id=:questionDataID",nativeQuery = true)
    ArrayList<Question> viewAllQuestions(@Param("questionDataID") Integer questionDataID);
}

