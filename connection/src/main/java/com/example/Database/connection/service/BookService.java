package com.example.Database.connection.service;


import com.example.Database.connection.model.entity.Book;
import com.example.Database.connection.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    private  BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> getLatestBook(){
        return bookRepository.findFirstByOrderByYearPublishedDesc();
    }
}
