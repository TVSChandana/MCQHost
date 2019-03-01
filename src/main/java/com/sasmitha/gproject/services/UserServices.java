package com.sasmitha.gproject.services;

import com.sasmitha.gproject.model.User;

import java.util.List;

public interface UserServices {

    List<User> findAllUsers();

    String saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User getUseById(Integer id);
}
