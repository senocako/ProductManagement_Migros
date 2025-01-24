package com.migros.product_app.model.service;

import com.migros.product_app.model.entity.Product;
import com.migros.product_app.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractProductService implements EntityService<Product, Integer>
{
    @Autowired
    protected ProductRepository productRepository;

    protected abstract List<Product> findAllByPriceGreaterThan(Double price);

    protected abstract List<Product> findAllByPriceLessThanEqual(Double price);
}
