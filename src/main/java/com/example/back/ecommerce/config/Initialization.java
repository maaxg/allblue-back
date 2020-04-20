package com.example.back.ecommerce.config;

import com.example.back.ecommerce.entities.Category;
import com.example.back.ecommerce.entities.Product;
import com.example.back.ecommerce.repositories.CategoryRepository;
import com.example.back.ecommerce.repositories.ProductRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Stream;

@Configuration
@Profile("test")
@Component

public class Initialization implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {

        /*Category c1 = new Category(null, "Shoes");
        categoryRepository.save(c1);

        productRepository.save(p1);
        p1.getCategories().add(c1);
        productRepository.save(p1);*/
        Product p1 = new Product(null, "Nike SB", 199.99, null, "Comfortable shoe by NIKE");
        Product p2 = new Product(null, "Air Jordan", 500.99, null, "Comfortable shoe by Nike");
        Stream.of(p1, p2).forEach(product ->
                productRepository.save(new Product(product)));

        Product fts =  productRepository.findByName(p1.getName());
        Category c = Category.builder().name("Shoes").build();
        fts.setCategories(Collections.singleton(c));
        productRepository.save(fts);




    }
}
