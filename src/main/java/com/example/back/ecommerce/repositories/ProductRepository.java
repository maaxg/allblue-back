package com.example.back.ecommerce.repositories;

import com.example.back.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByName(String name);

}
