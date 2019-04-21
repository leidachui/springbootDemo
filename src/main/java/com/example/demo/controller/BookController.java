package com.example.demo.controller;

import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ansonlei
 */
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/get_all_books")
    ModelAndView getBooks() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("books");
        mv.addObject("books", bookService.getAllBooks());
        return mv;
    }

}
