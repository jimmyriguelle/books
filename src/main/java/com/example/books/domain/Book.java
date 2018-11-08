package com.example.books.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // JPA
@Table(name = "book") // JPA
@Data // Lombok, génère les getters, setters, un constructeur ainsi que equals, hashCode et toString
public class Book {

    // JPA, définit la Primary Key
    @Id
    // JPA, auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // JPA, définition de la colonne
    @Column(name = "id")
    Long id;

    @Column(name = "isbn", length = 55, unique = true, nullable = false)
    String isbn;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", length = 512)
    String description;

    @Column(name = "publication_date")
    LocalDate publicationDate;

    @Column(name = "page_count")
    Long pageCount;

    @ManyToMany
    List<Author> authors;
}
