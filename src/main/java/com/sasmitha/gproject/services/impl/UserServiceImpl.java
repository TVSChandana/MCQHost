package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.additionalClasses.RequestData;
import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.repositories.UserRepository;
import com.sasmitha.gproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public int getConfermation(String pass, int logged_userId) {
      return  userRepository.getConfermation(pass,logged_userId);
    }

    @Override
    public int countUsers() {
        return userRepository.countUsers();
    }

    @Override
    public User search(Integer ID) {
        return userRepository.getOne(ID);
    }

    @Override
    public List<RequestData> getRequestData(int i, int loggedStudentId) {
        return userRepository.getRequestData(i,loggedStudentId);
    }

    @Override
    public String getAdminUserName(Integer admin_id) {
        return userRepository.getAdminUserName(admin_id);
    }


}
