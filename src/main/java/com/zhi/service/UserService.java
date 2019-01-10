package com.zhi.service;

import com.zhi.entity.Dept;
import com.zhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    List<Dept> getAllDept();
}
