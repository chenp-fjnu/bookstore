package com.online.bookstore.service;

import com.online.bookstore.domain.Book;
import com.online.bookstore.domain.ShoppingCartItem;
import com.online.bookstore.repository.BookRepository;
import com.online.bookstore.repository.ShoppingCartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @Mock
    private BookRepository bookRepository;

    private Book book1;
    private ShoppingCartItem cartItem1;
    private ShoppingCartItem cartItem2;

    @BeforeEach
    public void setUp() {
        book1 = new Book(1L, "Book1", "Author1", new BigDecimal("10.00"),"category1");
        Book book2 = new Book(2L, "Book2", "Author2", new BigDecimal("20.00"), "category2");
        cartItem1 = new ShoppingCartItem(1L, 1L, 1L, 10);
        cartItem2 = new ShoppingCartItem(2L, 1L, 2L, 40);
    }

    @Test
    public void testAddItemToCart() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));
        when(shoppingCartRepository.save(cartItem1)).thenReturn(cartItem1);

        ShoppingCartItem result = shoppingCartService.addItemToCart(cartItem1);

        assertEquals(cartItem1, result);
        verify(bookRepository).findById(1L);
        verify(shoppingCartRepository).save(cartItem1);
    }

    @Test
    public void testGetCartItems() {
        List<ShoppingCartItem> expected = Arrays.asList(cartItem1, cartItem2);
        when(shoppingCartRepository.findAllByCartId(1L)).thenReturn(expected);

        List<ShoppingCartItem> result = shoppingCartService.getCartItems(1L);

        assertEquals(expected, result);
        verify(shoppingCartRepository).findAllByCartId(1L);
    }

    @Test
    public void testCheckout() {
        BigDecimal expected = new BigDecimal("70.00");
        when(shoppingCartRepository.checkout(1L)).thenReturn(expected);

        BigDecimal result = shoppingCartService.checkout(1L);

        assertEquals(expected, result);
        verify(shoppingCartRepository).checkout(1L);
    }
}
