package com.zhi.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.zhi.common.RedisUtil;
import com.zhi.entity.Dept;
import com.zhi.entity.User;
import com.zhi.mapper.DeptMapper;
import com.zhi.mapper.UserMapper;
import com.zhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    // 查询类都是SUPPORTS
    // 增删改都是required
    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DeptMapper deptMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getAllUser() {
        // redisUtil.set("12345678","123");
        return userMapper.selectUser();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dept> getAllDept() {
        return deptMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertDept() {
        Dept dept = new Dept();
        dept.setDeptCode(78012);
        dept.setDeptName("alkp");
        dept.setDeptNote("notes");
        dept.setDeptSuper("123");
        deptMapper.insertSelective(dept);
        int i = 1/0;
        dept.setDeptSuper("124");
        dept.setDeptName("zjx");
        deptMapper.insertSelective(dept);
    }

    @Override
    public List<Dept> getPageDept(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Example example = new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace("aa")) {
            criteria.andLike("deptName", "%l%");
        }
        example.orderBy("deptCode").desc();
        List<Dept> deptList = deptMapper.selectByExample(example);
        return deptList;
    }

}
