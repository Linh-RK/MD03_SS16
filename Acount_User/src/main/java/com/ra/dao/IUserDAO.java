package com.ra.dao;

import com.ra.model.User;
import jdk.jfr.Category;

import java.util.List;

public interface IUserDAO {
    List<User> findAll();
    boolean create(User user);
    User findById(int id);
    Boolean update(User user);
    Boolean delete(int id);
}
