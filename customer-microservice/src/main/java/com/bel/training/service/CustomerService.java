package com.bel.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bel.training.model.Customer;
import com.bel.training.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> getCustomers(){
		return repo.findAll();
	}
	
	public List<Customer> saveCustomer(Customer c){
		repo.save(c);
		return repo.findAll();
	}
	
	public Customer getCustomer(Long pId) {
		return repo.findById(pId).get();
	}
	
	public Customer updateCustomer(Long id,Customer c) {
		return repo.save(c);
	}
	
	public void deleteCustomer(Long id) {
		repo.deleteById(id);
	}
}
