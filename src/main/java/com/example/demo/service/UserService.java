package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ansonlei
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> GetAllUsers() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andIdGreaterThan(0);

        List<User> userList = userMapper.selectByExample(userExample);

        return userList;
    }

    public int findUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return -1;
        } else {
            return 1;
        }
    }

    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

}
