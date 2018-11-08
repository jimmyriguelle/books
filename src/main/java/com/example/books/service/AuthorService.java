package com.example.books.service;

import com.example.books.domain.Author;
import com.example.books.service.exception.NotFoundException;

import java.util.List;

public interface AuthorService {

    Author create(Author author);

    List<Author> getAll();

    Author getById(Long id) throws NotFoundException;

    Author update(Author author) throws NotFoundException;

    void delete(Long id) throws NotFoundException;
}
