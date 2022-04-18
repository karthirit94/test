package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.model.DealProduct;

public interface DealProductRepository extends JpaRepository<DealProduct, Long> {

}
