package com.zhi.controller;

import com.alibaba.fastjson.JSON;
import com.zhi.entity.User;
import com.zhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value="/getUser")
    @ResponseBody
    public Object temps(Map<String, Object> model) {
        List<User> user_list = userService.getAllUser();
        user_list.forEach(user -> {user.setImgs(null);});
        return user_list;
    }

    /**
     * 测试错误页面的跳转
     * @return
     */
    @RequestMapping(value="/ers")
    public String ers() {
        int i = 1 / 0;
        return "test";
    }
    // 测试ajax的跳转

}