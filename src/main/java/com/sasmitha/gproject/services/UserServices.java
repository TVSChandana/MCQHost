package com.sasmitha.gproject.services;


import com.sasmitha.gproject.additionalClasses.RequestData;
import com.sasmitha.gproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    int validUserData(String userName, String password);

    String saveUser(User user);


    int getuserid(String userName);

    int getConfermation(String pass, int logged_userId);

    int countUsers();

    User search(Integer ID);

    List<RequestData> getRequestData(int i, int loggedStudentId);


    String getAdminUserName(Integer admin_id);
}
