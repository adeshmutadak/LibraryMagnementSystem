package com.example.BookLiberiesSystem.controller;

import com.example.BookLiberiesSystem.model.Book;
import com.example.BookLiberiesSystem.model.BookAwards;
import com.example.BookLiberiesSystem.model.Country;
import com.example.BookLiberiesSystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@Valid @RequestBody Book book ) {
        return bookService.addBook(book);
    }
    @GetMapping("/getAllBooks")
    public List<Book>getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id)
    {
        return bookService.deleteById(id);
    }
    @PutMapping("/updateBookById/{id}")
    public String updateBookById(@RequestBody Book book,@PathVariable Integer id) {
        return bookService.updateBookById(book,id);
    }
    ///find on bookname
    @GetMapping("/getByBookAuthorName/{name}")
    public List<Book>getByBookAuthorName(@PathVariable String name) {
        return bookService.getByBookAuthorName(name);
    }
        //find by book name
    @GetMapping("/getBookByBookName/{bookName}")
    public List<Book>getByBookName(@PathVariable String bookName) {
        return bookService.getByBookName(bookName);
        }

        @GetMapping("/getByCountryOrBookAwarads/{country}")
    public List<Book>getByCountryOrBookAwards(@PathVariable Country country ) {
        return bookService.getByCountryOrBookAwards(country);
        }

    }

