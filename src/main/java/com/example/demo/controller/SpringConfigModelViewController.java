package com.example.demo.controller;

import com.example.demo.bean.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ansonlei
 */
@Controller
public class SpringConfigModelViewController {
    @Autowired
    SpringConfig springConfig;

    @GetMapping("/spring_config_modelview")
    public ModelAndView GetConfig() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("springConfig", springConfig);
        mv.setViewName("spring_config");
        return mv;
    }
}
