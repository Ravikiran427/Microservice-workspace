package com.bel.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bel.training.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
