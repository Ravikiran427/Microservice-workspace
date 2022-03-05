package com.bel.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bel.training.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
