package com.example.books.rest;

import com.example.books.domain.Author;
import com.example.books.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class AuthorResource {

    private final Logger log = LoggerFactory.getLogger(AuthorResource.class);
    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/api/authors")
    public ResponseEntity createAuthor(@RequestBody Author author) {
        log.debug("Request to create author : " + author);
        Author created = authorService.create(author);
        return ResponseEntity
                .created(URI.create("/api/authors/" + created.getId()))
                .body(created);
    }
}
