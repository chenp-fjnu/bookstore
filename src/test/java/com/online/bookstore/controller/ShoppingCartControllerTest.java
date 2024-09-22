package com.online.bookstore.controller;


import com.online.bookstore.domain.ShoppingCartItem;
import com.online.bookstore.service.ShoppingCartService;
import io.swagger.annotations.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Api(tags = "Shopping Cart")
public class ShoppingCartControllerTest {

    @Mock
    private ShoppingCartService cartService;

    @InjectMocks
    private ShoppingCartController cartController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testViewCart() {
        Long cartId = 1L;
        List<ShoppingCartItem> cartItems = Arrays.asList(new ShoppingCartItem(1L, 1L, 1L, 10));
        when(cartService.getCartItems(cartId)).thenReturn(cartItems);

        List<ShoppingCartItem> result = cartController.viewCart(cartId);

        assertEquals(cartItems, result);
        verify(cartService, times(1)).getCartItems(cartId);
    }

    @Test
    public void testAddToCart() {
        ShoppingCartItem item = new ShoppingCartItem(1L, 1L, 1L, 10);
        when(cartService.addItemToCart(item)).thenReturn(item);

        ShoppingCartItem result = cartController.addToCart(item);

        assertEquals(item, result);
        verify(cartService, times(1)).addItemToCart(item);
    }

    @Test
    public void testCheckout() {
        Long cartId = 1L;
        BigDecimal totalPrice = new BigDecimal("100.00");
        when(cartService.checkout(cartId)).thenReturn(totalPrice);

        ResponseEntity<BigDecimal> result = cartController.checkout(cartId);

        assertEquals(ResponseEntity.ok(totalPrice), result);
        verify(cartService, times(1)).checkout(cartId);
    }
}

