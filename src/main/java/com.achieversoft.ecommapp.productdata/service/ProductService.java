package com.achieversoft.ecommapp.productdata.service;

import com.achieversoft.ecommapp.productdata.common.exception.ProductDataException;
import com.achieversoft.ecommapp.productdata.entity.Product;
import com.achieversoft.ecommapp.productdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     * @throws ProductDataException the product data exception
     */
    public Product getProductById(String id) throws ProductDataException {
        return repository.findById(id).get();
    }

    /**
     * Gets products.
     *
     * @return the products
     * @throws ProductDataException the product data exception
     */
    public List<Product> getProducts() throws ProductDataException {
        return repository.findAll();
    }

    /**
     * Save or update product string.
     *
     * @param list the list
     * @return the string
     * @throws ProductDataException the product data exception
     */
    public String saveOrUpdateProduct(List<Product> list) throws ProductDataException {
        int count=repository.saveAll(list).size();
        return "Updated "+count+" Records";
    }

    /**
     * Delete all product string.
     *
     * @return the string
     * @throws ProductDataException the product data exception
     */
    public String deleteAllProduct() throws ProductDataException {
        repository.deleteAll();
        return "All Records Deleted Successfully.";
    }

    /**
     * Delete product string.
     *
     * @param id the id
     * @return the string
     * @throws ProductDataException the product data exception
     */
    public String deleteProduct(String id) throws ProductDataException {
        repository.delete(Product.builder().productId(id).build());
        return "Product Id "+id+" Deleted Successfully.";
    }


}
