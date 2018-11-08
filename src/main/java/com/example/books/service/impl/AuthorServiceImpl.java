package com.example.books.service.impl;

import com.example.books.domain.Author;
import com.example.books.repository.AuthorRepository;
import com.example.books.service.AuthorService;
import com.example.books.service.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        log.debug("Trying to create author : " + author);
        return authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll() {
        log.debug("Trying to get all authors");
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Author getById(Long id) throws NotFoundException {
        log.debug("Trying to get author by id : " + id);
        return authorRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Author update(Author author) throws NotFoundException {
        log.debug("Trying to update author : " + author);
        if (!authorRepository.existsById(author.getId())) {
            throw new NotFoundException();
        }
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        log.debug("Trying to delete author : " + id);
        if (!authorRepository.existsById(id)) {
            throw new NotFoundException();
        }
        authorRepository.deleteById(id);
    }
}
