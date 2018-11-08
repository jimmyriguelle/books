package com.example.books.repository;

import com.example.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Query method name
    List<Book> findAllByTitleContaining(String title);

    // JPQL
    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.authors WHERE b.publicationDate >= CURRENT_DATE")
    List<Book> findCustom();

    // Native query SQL
    @Query(nativeQuery = true, value = "SELECT * FROM book")
    List<Book> findCustomSql();
}
