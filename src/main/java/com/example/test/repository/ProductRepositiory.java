package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Product;

@Repository
public interface ProductRepositiory extends JpaRepository<Product, Long>{

}
