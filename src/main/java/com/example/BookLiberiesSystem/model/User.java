package com.example.BookLiberiesSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotEmpty
    @Column(name = "First Name")
    private String firstName;

    @Column(name = "Last Name")
    private  String lastName;

    @NotEmpty
    @Length(min = 10, max = 10 , message = "Enter Valid Number")
    private String phoneNumber;

    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private  List<Book>bookList;
}
