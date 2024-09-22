package com.online.bookstore.service;


import com.online.bookstore.domain.Book;
import com.online.bookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;
    private List<Book> books;

    @BeforeEach
    public void setUp() {
        book1 = new Book(1L, "Book1", "Author1", new BigDecimal("10.0"), "Category1");
        book2 = new Book(2L, "Book2", "Author2", new BigDecimal("20.0"), "Category2");
        books = Arrays.asList(book1, book2);
    }

    @Test
    public void testAddBook() {
        when(bookRepository.save(book1)).thenReturn(book1);
        Book savedBook = bookService.addBook(book1);
        assertEquals(book1, savedBook);
        verify(bookRepository, times(1)).save(book1);
    }

    @Test
    public void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> allBooks = bookService.getAllBooks();
        assertEquals(books, allBooks);
        verify(bookRepository, times(1)).findAll();
    }
}

