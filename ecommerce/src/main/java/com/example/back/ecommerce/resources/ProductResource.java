package com.example.back.ecommerce.resources;

import com.example.back.ecommerce.entities.Product;
import com.example.back.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "{/id}")
    public ResponseEntity<Product> findById(@PathVariable("/id") String id){
        Product obj = (Product) service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    

}
