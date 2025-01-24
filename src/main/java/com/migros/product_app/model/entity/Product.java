package com.migros.product_app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name = "PRODUCTS_SEQUENCE", sequenceName = "MIGROS_PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "PRODUCTS")
@Entity
public class Product
{

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_SEQUENCE")
    @Column(name = "PRODUCT_ID")
    @Id
    private Integer productId;

    private String name;

    private String category;

    private String description;

    private Double price;

    private Date created;
}
