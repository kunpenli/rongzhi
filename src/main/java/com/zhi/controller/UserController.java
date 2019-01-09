package com.zhi.controller;

import com.alibaba.fastjson.JSON;
import com.zhi.entity.User;
import com.zhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/allu")
    public String temp(Map<String, Object> model) {
        List<User> user_list = userService.getAllUser();
        model.put("message","hello"+ JSON.toJSONString(user_list));
        return "test";
    }
}