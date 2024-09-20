package com.online.bookstore.repository;

import com.online.bookstore.domain.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartItem, Long> {
    @Query(value ="select * from cart_items c where cart_id=:cart_id ",nativeQuery = true)
    public List<ShoppingCartItem> findAllByCartId(Long cart_id);
    @Query(value ="select sum(b.price * c.quantity) from cart_items c left join books b on c.book_id= b.id where cart_id=:cart_id ",nativeQuery = true)
    public BigDecimal checkout(Long cart_id);
}