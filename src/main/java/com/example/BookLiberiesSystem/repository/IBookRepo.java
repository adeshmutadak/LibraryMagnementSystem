package com.example.BookLiberiesSystem.repository;

import com.example.BookLiberiesSystem.model.Book;
import com.example.BookLiberiesSystem.model.BookAwards;
import com.example.BookLiberiesSystem.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepo extends JpaRepository<Book, Integer> {
List<Book> findByAuthorName(String name);

List<Book>findByBookName(String bookName);

List<Book>findByCountry(Country country);

}
