package com.migros.product_app.controller;

import com.migros.product_app.model.entity.Product;
import com.migros.product_app.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/product")
//@RestController
public class ProductController
{
    @Autowired
    private AbstractProductService productService;

    @DeleteMapping("{productId}")
    public ResponseEntity<String> delete(@PathVariable Integer productId)
    {
        Product productFound = productService.findById(productId);

        if (productFound != null)
        {
            productService.deleteById(productId);
            return ResponseEntity.ok("Product which have productId " + productId + " has been deleted.");
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "id") Integer productId)
    {
        Product productFound = productService.findById(productId);

        return productFound != null ? ResponseEntity.ok(productFound) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product)
    {
        product.setCreated(new Date());

        Product savedProduct = productService.insert(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll()
    {
        // return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
        return ResponseEntity.ok(productService.getAll());
    }
}
