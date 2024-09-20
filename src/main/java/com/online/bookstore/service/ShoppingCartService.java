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

    public ShoppingCartItem addItemToCart(ShoppingCartItem cartItem) {
        Book book = bookRepository.findById(cartItem.getBookId()).orElseThrow();
        return shoppingCartRepository.save(cartItem);
    }
    public List<ShoppingCartItem> getCartItems(Long cartId) {
        return shoppingCartRepository.findAllByCartId(cartId);
    }

    public BigDecimal checkout(Long cartId) {
        return shoppingCartRepository.checkout(cartId);
    }
}