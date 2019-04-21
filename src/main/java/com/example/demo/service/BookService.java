package com.example.demo.service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ansonlei
 */
@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }
}
