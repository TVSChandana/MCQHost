package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.repositories.UserRepository;
import com.sasmitha.gproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;


    @Override
    public int validUserData(String userName, String password) {
        return userRepository.getUserAvailability(userName,password);

    }

    @Override
    public String saveUser(User user) {
        userRepository.save(user);
        return "Data Saved";
    }

    @Override
    public int getuserid(String userName) {
        return userRepository.getuserid(userName);
    }

}
