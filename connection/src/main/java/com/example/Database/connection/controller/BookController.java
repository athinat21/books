package com.example.Database.connection.controller;


import com.example.Database.connection.model.entity.Book;
import com.example.Database.connection.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // POST /books
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/latest")
    //do e kthej nje objekt te tipit Book nese gjendet
    //dhe do te kete nje status http te pershtatshem(200 ose 404)
    public ResponseEntity<Book> getLatestBook(){
        return bookService.getLatestBook()
                //nese ekziston nje liber (Optional tregon nese eshte prezent apo jo
        //mbyllet brenda ResponseEntity
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
