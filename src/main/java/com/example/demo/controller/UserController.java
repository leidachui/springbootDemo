package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.elasticsearch.common.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author ansonlei
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/get_all_users.mv", method = GET, produces = "application/json")
    @GetMapping("/get_all_users.mv")
    public ModelAndView GetUsers() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_db");

        List<User> userList = userService.GetAllUsers();
        mv.addObject("users", userList);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/get_all_users", method = GET, produces = "application/json")
    public List<User> getAllUsers() {
        List<User> userList = userService.GetAllUsers();
        return userList;
    }

    @ResponseBody
    @RequestMapping(value = "/insert_user", method = POST, produces = "application/json")
    public String saveUser(@RequestBody User user){
        int exist = userService.findUserById(user.getId());
        if (exist == 1) {
            return String.format("id: %d is already exist.", user.getId());
        }
        int ret = userService.insertUser(user);
        System.out.printf("insert ret: %d", ret);
        // 返回受影响的行数
        if (ret > 0) {
            return "insert success.";
        } else {
            return "insert failed.";
        }
    }

}