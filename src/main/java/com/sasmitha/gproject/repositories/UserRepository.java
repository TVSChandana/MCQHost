package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer > {
//    @Query(value = "SELECT count(User_Name) FROM User_Data WHERE User_Name=:uname",nativeQuery = true)
//    int getCount(@Param("uname") String uname);

    @Query(value = "SELECT count(username) FROM User_Table WHERE username=:username AND Password=:password ",nativeQuery = true)
    int getUserAvailability(@Param("username") String userName, @Param("password") String password);
}
