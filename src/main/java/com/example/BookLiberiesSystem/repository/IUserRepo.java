package com.example.BookLiberiesSystem.repository;

import com.example.BookLiberiesSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepo extends JpaRepository<User,Integer> {
    List<User>findByFirstNameOrLastName(String firstName,String lastName);

    List<User> findByPhoneNumber(String phoneNumber);
}
