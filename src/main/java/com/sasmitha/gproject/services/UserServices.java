package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.User;

public interface UserServices {

    int validUserData(String userName, String password);

    String saveUser(User user);


    int getuserid(String userName);

    int getConfermation(String pass, int logged_userId);

}
