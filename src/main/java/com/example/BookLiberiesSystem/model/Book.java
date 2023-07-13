package com.example.BookLiberiesSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BooksInformation")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BookId")
    private Integer bookId;

    @NotEmpty
    @Column(name = "BookName", unique = true)
    private String bookName;

    @Column(name = "AuthorName")
    @NotEmpty
    private String authorName;

    @Column(name = "AuthorCountry")
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "BookPages")
    private Integer bookPages;

    @Column(name = "BookAwards")
    @Enumerated(EnumType.STRING)
    private BookAwards bookAwards;

    @Column(name = "ReleasedYear")
    @Length(min = 4, max = 4 ,message = "Please Enter a Correct Year")
    private String releasedYear;

}
