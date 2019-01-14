package com.zhi.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zhi.entity.Dept;
import com.zhi.entity.User;
import com.zhi.entity.dto.MyLog;
import com.zhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Value("${other.p1}")
    private String p1;
    @Autowired
    private UserService userService;
    @RequestMapping(value="/allu")
    public String temp(Map<String, Object> model) {
        List<User> user_list = userService.getAllUser();
        List<Dept> dept_list = userService.getAllDept();
        userService.insertDept();
        model.put("message","hello"+ JSON.toJSONString(user_list)+ JSON.toJSONString(dept_list));
        return "test";
    }
    @MyLog(value = "查询用户信息")
    @RequestMapping(value="/getUser")
    @ResponseBody
    public Object temps(Map<String, Object> model) {
        List<User> user_list = userService.getAllUser();
        user_list.forEach(user -> user.setImgs(null));
        return user_list;
    }
    @RequestMapping(value="/getDeptPage")
    @ResponseBody
    public Object pageDept() {
        List<Dept> deptList = userService.getPageDept(1, 2);
        return deptList;
    }

    /**
     * 测试错误页面的跳转
     * @return
     */
    @RequestMapping(value="/erss")
    public String ers() {
        System.out.println(p1);
        int i = 1 / 0;
        return "test";
    }
    // 测试ajax的跳转

}