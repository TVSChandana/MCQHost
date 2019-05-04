package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers,Integer> {

    @Query(value = "SELECT * FROM Answers_Table WHERE Student_Id=:g_student_id AND Question_Data_Id=:g_question_data_id ",nativeQuery = true)
    List<Answers> getTestdata(@Param("g_student_id") Integer g_student_id, @Param("g_question_data_id") Integer g_question_data_id);

    @Query(value = "SELECT count(*) FROM Answers_Table WHERE Student_Id=:g_student_id AND Question_Data_Id=:g_question_data_id ",nativeQuery = true)
    int getQuestionCount(@Param("g_student_id") Integer g_student_id, @Param("g_question_data_id") Integer g_question_data_id);

    @Query(value = "SELECT count(*) FROM Answers_Table WHERE Student_Id=:g_student_id AND Question_Data_Id=:g_question_data_id AND Answered_Or_Not='Not Answered' ",nativeQuery = true)
    int getUnAnsweredQuestionNumberCount(@Param("g_student_id") Integer g_student_id, @Param("g_question_data_id") Integer g_question_data_id);

    @Query(value = "SELECT count(*) FROM Answers_Table WHERE Student_Id=:g_student_id AND Question_Data_Id=:g_question_data_id AND Answer_Status=0",nativeQuery = true)
    int getIncorrectQuestions(@Param("g_student_id") Integer g_student_id, @Param("g_question_data_id") Integer g_question_data_id);

    @Query(value = "SELECT SUM(mark) FROM Answers_Table WHERE Student_Id=:g_student_id AND Question_Data_Id=:g_question_data_id ",nativeQuery = true)
    int getTotalMarks(@Param("g_student_id") Integer g_student_id, @Param("g_question_data_id") Integer g_question_data_id);

    @Query(value = "SELECT SUM(Student_mark) FROM Answers_Table WHERE Student_Id=:g_student_id AND Question_Data_Id=:g_question_data_id ",nativeQuery = true)
    int getStudentMarks(@Param("g_student_id") Integer g_student_id, @Param("g_question_data_id") Integer g_question_data_id);

}
