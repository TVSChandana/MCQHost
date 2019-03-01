package com.sasmitha.gproject.services.impl;

import com.sasmitha.gproject.model.User;
import com.sasmitha.gproject.repositories.UserRepository;
import com.sasmitha.gproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        List<User> allusers=userRepository.findAll();
        return  allusers;
    }

    @Override
    public String saveUser(User user) {
        userRepository.save(user);
        return "Data Saved";
    }

    @Override
    public void updateUser(User user) {
     if (user.getId()!=null){
         userRepository.save(user);
     }

    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUseById(Integer id) {
        return  userRepository.getOne(id);
    }
}
