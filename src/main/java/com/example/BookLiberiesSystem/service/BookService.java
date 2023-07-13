package com.example.BookLiberiesSystem.service;

import com.example.BookLiberiesSystem.model.Book;
import com.example.BookLiberiesSystem.model.BookAwards;
import com.example.BookLiberiesSystem.model.Country;
import com.example.BookLiberiesSystem.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepo iBookRepo;
    public String addBook(Book book) {
        iBookRepo.save(book);
        return "Book Registered Successfully";
    }

    public List<Book> getAllBooks() {
        return iBookRepo.findAll();
    }

    public String deleteById(Integer id) {
        if(!iBookRepo.findById(id).isPresent()) {
            return "Book Id Not Found Check It Again";
        }
       iBookRepo.deleteById(id);
        return "BookInformation With this Id Deleted Successfully";
    }

    public String updateBookById( Book book,Integer id) {
       if(!iBookRepo.findById(id).isPresent()) {
            return  "Id not Found Check Once Again";
       }
       Book book1=iBookRepo.findById(id).get();
       book1.setBookName(book.getBookName());
       book1.setBookPages(book.getBookPages());
       book1.setAuthorName(book.getAuthorName());
       book1.setCountry(book.getCountry());
       book1.setBookAwards(book.getBookAwards());
       book1.setReleasedYear(book.getReleasedYear());
       iBookRepo.save(book1);
       return  "Book Information Updated Successfully ";
    }


    public List<Book> getByBookAuthorName(String name) {
        return iBookRepo.findByAuthorName(name);
    }

    public List<Book> getByBookName(String bookName) {
        return iBookRepo.findByBookName(bookName);
    }

    public List<Book> getByCountryOrBookAwards(Country country ) {
        return iBookRepo.findByCountry(country);
    }
}
