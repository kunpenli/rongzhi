package com.zhi.service.serviceimpl;

import com.zhi.common.RedisUtil;
import com.zhi.entity.Dept;
import com.zhi.entity.User;
import com.zhi.mapper.DeptMapper;
import com.zhi.mapper.UserMapper;
import com.zhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DeptMapper deptMapper;
    @Override
    public List<User> getAllUser() {
        redisUtil.set("12345678","123");
        return userMapper.selectUser();
    }
    @Override
    public List<Dept> getAllDept() {
        return deptMapper.selectAll();
    }
}
