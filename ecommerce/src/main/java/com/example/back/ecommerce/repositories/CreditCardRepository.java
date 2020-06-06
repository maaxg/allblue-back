package com.example.back.ecommerce.repositories;

import com.example.back.ecommerce.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
}
