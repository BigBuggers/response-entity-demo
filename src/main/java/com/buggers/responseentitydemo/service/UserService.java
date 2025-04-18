package com.buggers.responseentitydemo.service;



import com.buggers.responseentitydemo.dto.User;

import java.util.List;


public interface UserService {
    User addUser(User user);

    List<User> getUsers();

    boolean updateUser(String userId, User user);

    boolean deleteUser(String userId);
}
