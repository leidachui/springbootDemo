package com.example.demo.controller;

import com.example.demo.bean.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ansonlei
 */
@RestController
public class ServerConfigController {

    @Autowired
    ServerConfig serverConfig;

    @GetMapping("/server_config")
    public String GetConfig() {
        return serverConfig.toString();
    }
}
