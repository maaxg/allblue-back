package com.example.back.ecommerce.services;

import com.example.back.ecommerce.entities.Product;
import com.example.back.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){ return repository.findAll();}

    public Product findById(String id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
