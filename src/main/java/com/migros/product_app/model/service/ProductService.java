package com.migros.product_app.model.service;

import com.migros.product_app.model.entity.Product;
import com.migros.product_app.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractProductService
{

    @Override
    protected List<Product> findAllByPriceGreaterThan(Double price)
    {
        try
        {
            return productRepository.findAllByPriceGreaterThan(price);
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    protected List<Product> findAllByPriceLessThanEqual(Double price)
    {
        try
        {
            return productRepository.findAllByPriceLessThanEqual(price);
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteById(Integer id)
    {
        try
        {
            productRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
        }
    }

    @Override
    public Product findById(Integer id)
    {
            try
            {
                return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
            }
            catch (NullPointerException e)
            {
                Util.showGeneralExceptionInfo(e);
                return null;
            }
            catch (IllegalArgumentException e)
            {
                Util.showGeneralExceptionInfo(e);
                return null;
            }
            catch (RuntimeException e)
            {
                Util.showGeneralExceptionInfo(e);
                return null;
            }
    }

    @Override
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Product insert(Product product)
    {
        try
        {
            return productRepository.save(product);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
        catch (OptimisticLockingFailureException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }
}
