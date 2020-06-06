package com.example.back.ecommerce.config;

import com.example.back.ecommerce.entities.*;
import com.example.back.ecommerce.entities.enums.OrderStatus;
import com.example.back.ecommerce.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Configuration
@Profile("test")
@Component
public class Initialization implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Override
    public void run(String... args) throws Exception {


        Category c1 = new Category(null, "Shoes");
        categoryRepository.save(c1);

        CreditCard creditCard = new CreditCard(null, "Maxsuel Gomes P Silva", "1234 1234 1234 1234", "17/25", "441");
        creditCardRepository.save(creditCard);
        User u1 = new User(null, "admin", "adm", "123.123.123-12", "admin@gmail.com", (new BCryptPasswordEncoder().encode("1234")), "154897-654", "Rua Carochinha", 154, "Jhonson Neigh", null);
        User u2 = new User(null, "Maxsuel", "Gomes", "707.142.536-35", "max@gmail.com", (new BCryptPasswordEncoder().encode("12345")), "154897-654", null, null, null, creditCard);
        userRepository.saveAll(Arrays.asList(u1, u2));


        String path_nikesb = "C:\\Users\\PC\\IdeaProjects\\ecommerce\\img\\nike2.jpg";
        String path_jordan = "C:\\Users\\PC\\IdeaProjects\\ecommerce\\img\\nikejordan.jpg";



        Product p1 = new Product(null, "Nike SB", 199.99, path_nikesb, "Comfortable shoe by NIKE");
        Product p2 = new Product(null, "Air Jordan", 500.99, path_jordan , "Comfortable shoe by Nike");
        productRepository.saveAll(Arrays.asList(p1, p2));

        p1.getCategories().add(c1);
        p2.getCategories().add(c1);
       /* Stream.of(p1, p2).forEach(product ->
                productRepository.save(new Product(product)));*/

        productRepository.saveAll(Arrays.asList(p1, p2));

       /* Product fts =  productRepository.findByName(p1.getName());
        Category c = Category.builder().name("Shoes").build();
        fts.setCategories(Collections.singleton(c));
        productRepository.save(fts);*/


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        orderRepository.save(o1);
        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        orderItemRepository.save(oi1);



        orderRepository.saveAll(Arrays.asList(o1));



    }
}
