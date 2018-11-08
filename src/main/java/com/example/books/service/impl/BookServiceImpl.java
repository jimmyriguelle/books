package com.example.books.service.impl;


import com.example.books.domain.Book;
import com.example.books.repository.BookRepository;
import com.example.books.service.BookService;
import com.example.books.service.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book getById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Book getByName(String title) {
        return null;
    }

    @Override
    public Book update(Book book) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws NotFoundException {

    }
}
