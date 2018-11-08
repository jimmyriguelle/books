package com.example.books.service;

import com.example.books.domain.Book;
import com.example.books.service.exception.NotFoundException;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> getAll();

    Book getById(Long id) throws NotFoundException;

    Book getByName(String title);

    Book update(Book book) throws NotFoundException;

    void  delete (Long id) throws NotFoundException;
}
