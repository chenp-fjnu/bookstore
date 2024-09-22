package com.online.bookstore.controller;


import com.online.bookstore.domain.Book;
import com.online.bookstore.service.BookService;
import io.swagger.annotations.Api;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Api(tags = "Book Management")
public class BookControllerTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = Arrays.asList(new Book(1L, "Book1","author1",new BigDecimal("10.0"),"category1"),
                new Book(2L, "Book2","author2",new BigDecimal("20.0"),"category2"));
        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{\"id\":1,\"title\":\"Book1\",\"author\":\"author1\",\"price\":10,\"category\":\"category1\"},{\"id\":2,\"title\":\"Book2\",\"author\":\"author2\",\"price\":20,\"category\":\"category2\"}]"));
    }

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book(1L, "Book1","author1",new BigDecimal("10.0"),"category1");
        when(bookService.findBookById(1L)).thenReturn(book);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Book1\",\"author\":\"author1\",\"price\":10,\"category\":\"category1\"}"))
                .andExpect(status().isOk());
        Book savedBook = bookService.findBookById(1L);
        assertEquals(book, savedBook);
    }
}

