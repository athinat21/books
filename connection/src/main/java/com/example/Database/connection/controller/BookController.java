package com.example.Database.connection.controller;


import com.example.Database.connection.model.entity.Book;
import com.example.Database.connection.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //get /books
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
