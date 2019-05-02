package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.additionalClasses.RequestData;
import com.sasmitha.gproject.model.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer > {
//    @Query(value = "SELECT count(User_Name) FROM User_Data WHERE User_Name=:uname",nativeQuery = true)
//    int getCount(@Param("uname") String uname);

    @Query(value = "SELECT count(username) FROM User_Table WHERE username=:username AND Password=:password ",nativeQuery = true)
    int getUserAvailability(@Param("username") String userName, @Param("password") String password);

    @Query(value = "SELECT ID FROM User_Table WHERE username=:username",nativeQuery = true)
    int getuserid(@Param("username") String userName);

    @Query(value = "SELECT count(username) FROM User_Table WHERE ID=:logged_userId AND Password=:pass",nativeQuery = true)
    int getConfermation(@Param("pass") String pass,@Param("logged_userId") Integer logged_userId);

    @Query(value = "SELECT count(*) FROM User_Table",nativeQuery = true)
    int countUsers();

    @Query(value = "SELECT  ID,first_name,last_name,Request_Id  FROM User_Table t Join Request_Table r  on t.ID=r.Admin_Id WHERE r.Request_status=:i and r.Student_Id=:loggedStudentId",nativeQuery = true)
    List<RequestData> getRequestData(@Param("i") Integer i, @Param("loggedStudentId") Integer loggedStudentId);


//    @Query(value = "SELECT  t.ID,t.first_name,t.last_name,r.Request_Id  FROM User_Table t Join Request_Table r  on t.ID=r.Admin_Id WHERE r.Request_status=:i and r.Student_Id=:loggedStudentId",nativeQuery = true)
//    List<RequestData> getRequestData(@Param("i") Integer i, @Param("loggedStudentId") Integer loggedStudentId);
}
