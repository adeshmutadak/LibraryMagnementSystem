package com.example.BookLiberiesSystem.service;

import com.example.BookLiberiesSystem.model.User;
import com.example.BookLiberiesSystem.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;
    public String addUser(User user) {
        iUserRepo.save(user);
        return  "User Added Successfully";
    }

    public List<User> getAllUsers() {
        return iUserRepo.findAll();
    }

    public String deleteUser(Integer id) {
        if (!iUserRepo.findById(id).isPresent()) {
            return "Id not Found for Delete The User Check it Try Again";
        }
        iUserRepo.deleteById(id);
        return "User Deleted Successfully";
    }

    public String updateUser(Integer id , User user) {
        if(!iUserRepo.findById(id).isPresent()) {
            return "User Id Not Found For Update";
        }
        User user1 = iUserRepo.findById(id).get();
         user1.setFirstName(user.getFirstName());
         user1.setLastName(user.getLastName());
         user1.setPhoneNumber(user.getPhoneNumber());
         user1.setAddress(user.getAddress());
         user1.setBookList(user.getBookList());
         iUserRepo.save(user1);
         return "User Information Updated Successfully";
    }

    public List<User> getFirstName(String firstName,String lastName) {
        return iUserRepo.findByFirstNameOrLastName(firstName,lastName);
    }

    public List<User> getByNumber(String phoneNumber) {
        return iUserRepo.findByPhoneNumber(phoneNumber);
    }
}
