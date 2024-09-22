package com.online.bookstore.service;

import com.online.bookstore.domain.Book;
import com.online.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Add a book to the database
    public Book addBook(Book book) {
        /* TODO:
        * 1. check if the book already exists in the database (by title and author)
        * 2. if it does, update the existing book object
        * 3. if it doesn't, create a new book and save it to the database
        * 4. return the new or existing book object
        */
        return bookRepository.save(book);
    }
    // find  book by id
    public Book findBookById(Long id) {
        return bookRepository.findById(id).isPresent()? bookRepository.findById(id).get() : null;
    }

    // Get all books from the database
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
