package com.online.bookstore.controller;

import com.online.bookstore.domain.ShoppingCartItem;
import com.online.bookstore.service.BookService;
import com.online.bookstore.service.ShoppingCartService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(tags = "Shopping Cart")
@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController {
    private final ShoppingCartService cartService;
    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @ApiOperation("Get all items of specific cart")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "Long", name = "cartId", value = "id of cart", required = true) })
    @GetMapping("/{cartId}")
    public List<ShoppingCartItem> viewCart(@PathVariable("cartId") Long cartId) {
        return cartService.getCartItems(cartId);
    }
    @ApiOperation("Add item to specific cart")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "ShoppingCartItem", name = "item", value = "item of cart", required = true) })
    @PostMapping
    public ShoppingCartItem addToCart(@RequestBody ShoppingCartItem item) {
        return cartService.addItemToCart(item);
    }
    @ApiOperation("Checkout for specific cart")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "Long", name = "cartId", value = "id of cart", required = true) })
    @GetMapping("/{cartId}/checkout")
    public ResponseEntity<BigDecimal> checkout(@PathVariable("cartId") Long cartId) {
        return ResponseEntity.ok(cartService.checkout(cartId));
    }
}
