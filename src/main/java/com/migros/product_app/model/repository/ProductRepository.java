package com.migros.product_app.model.repository;

import com.migros.product_app.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    // SELECT * FROM PRODUCTS WHERE PRICE > ?;
    List<Product> findAllByPriceGreaterThan(Double price);

    // SELECT * FROM PRODUCTS WHERE PRICE <= ?;
    List<Product> findAllByPriceLessThanEqual(Double price);
}
