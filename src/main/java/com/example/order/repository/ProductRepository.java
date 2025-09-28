package com.example.order.repository;

import com.example.order.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


    Optional<Product> findByP_descriptions(String nonExisting);
}
