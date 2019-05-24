package com.sasmitha.gproject.repositories;


import com.sasmitha.gproject.model.StudentAnswerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentAnswerDataRepository extends JpaRepository<StudentAnswerData,Integer> {

    @Query(value = "SELECT *  FROM Student_Answer_Table WHERE QUESTION_DATA_ID=:questionDataID",nativeQuery = true)
    List<StudentAnswerData> getStudentAnswersData(@Param("questionDataID") Integer questionDataID);


}
