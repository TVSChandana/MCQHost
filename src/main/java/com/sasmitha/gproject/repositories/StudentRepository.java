package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.additionalClasses.RequestData;
import com.sasmitha.gproject.additionalClasses.StudentRequestData;
import com.sasmitha.gproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT count(username) FROM Student_Table WHERE username=:username AND Password=:password ",nativeQuery = true)
    int getUserAvailability(@Param("username") String userName, @Param("password") String password);

    @Query(value = "SELECT count(*) FROM Student_Table",nativeQuery = true)
    int countStudents();

    @Query(value = "SELECT ID FROM Student_Table WHERE username=:username",nativeQuery = true)
    int getstudentId(@Param("username") String userName);

    @Query(value = "SELECT  ID,first_name,last_name,Request_Id  FROM Student_Table t Join Request_Table r  on t.ID=r.Student_Id WHERE r.Request_status=:i and r.Admin_Id=:loggedUserId",nativeQuery = true)
    List<StudentRequestData> getStudentFollowerData(@Param("i") Integer i, @Param("loggedUserId") Integer loggedUserId);
}
