package com.online.bookstore.domain;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value ="primary key", notes="id of card item", hidden = true)
    private Long id;

    @ApiModelProperty(notes ="cart id of cart item", required = true)
    @Column(name = "cart_id")
    private Long cartId;
    @ApiModelProperty(notes ="book id of cart item", required = true)
    @Column(name = "book_id")
    private Long bookId;
    @ApiModelProperty(notes ="quantity of book in cart item", required = true)
    @Column(name = "quantity")
    private int quantity;

}
