package com.online.bookstore.controller;

import com.online.bookstore.domain.Book;
import com.online.bookstore.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Book Management")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    // Get all books in store
    @ApiOperation("Get all books in store")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    // Add book to store
    @ApiOperation("Add book to store")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "Book", name = "book", value = "book information", required = true) })

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
