package com.achieversoft.ecommapp.productdata.repository;


import com.achieversoft.ecommapp.productdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


}
