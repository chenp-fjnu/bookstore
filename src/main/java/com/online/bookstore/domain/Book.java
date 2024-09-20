package com.online.bookstore.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Data
@ApiModel(description = "Book information")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value ="primary key", notes="id of book", hidden = true)
    private Long id;
    @ApiModelProperty(notes ="title of book", required = true)
    private String title;
    @ApiModelProperty(notes ="author of book", required = true)
    private String author;
    @ApiModelProperty(notes ="price of book", required = true)
    private BigDecimal price;
    @ApiModelProperty(notes ="category of book", required = true)
    private String category;
}