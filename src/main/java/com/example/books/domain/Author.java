package com.example.books.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "first_name", nullable = false)
    String firstName;
}
