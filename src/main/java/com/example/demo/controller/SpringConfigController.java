package com.example.demo.controller;

import com.example.demo.bean.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ansonlei
 */
@RestController
public class SpringConfigController {
    @Autowired
    SpringConfig springConfig;

    @GetMapping("/spring_config")
    public String GetConfig() {
        return springConfig.toString();
    }
}
