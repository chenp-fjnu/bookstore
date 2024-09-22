package com.online.bookstore.service;

import com.online.bookstore.domain.Book;
import com.online.bookstore.domain.ShoppingCartItem;
import com.online.bookstore.repository.BookRepository;
import com.online.bookstore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookRepository bookRepository;

    //Add a book to the shopping cart
    public ShoppingCartItem addItemToCart(ShoppingCartItem cartItem) {
        //Find the book by ID
        /* TODO
        * 1. Book validation:
        * If the book is not found, throw a custom exception or handle the error as per your application's requirements.
        * We can also return a default or error book object to indicate that the book was not found.
        * Example: throw new BookNotFoundException("Book not found with ID: " + cartItem.getBookId());
        *
        * 2. cartid logic:
        * cartid can be seperated by user id and validate base on user session.
        * It means cardid can hidden from request and get from user session directly.
        *
        * 3.Cart item validation:
        * Check if the cart item already exists for the given book ID. If it does, increase the quantity.
        * If not, create a new cart item.
        */
        bookRepository.findById(cartItem.getBookId()).orElseThrow();
        return shoppingCartRepository.save(cartItem);
    }
    //Get all the books in the shopping cart
    public List<ShoppingCartItem> getCartItems(Long cartId) {
        //Find all the cart items by cart ID
        return shoppingCartRepository.findAllByCartId(cartId);
    }

    //Checkout the shopping cart
    public BigDecimal checkout(Long cartId) {
        //Calculate the total price of the shopping cart
        return shoppingCartRepository.checkout(cartId);
    }
}