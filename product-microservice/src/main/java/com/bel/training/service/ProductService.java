package com.bel.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bel.training.model.Product;
import com.bel.training.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	
	public List<Product> getProducts(){
		return prepo.findAll();
		}

		public List<Product> saveProduct(Product p){
		prepo.save(p);
		return prepo.findAll();
		}

		public Product get(Long id) {
		return prepo.findById(id).get();
		}

		public Product updateProduct(Long id,Product p) {
		return prepo.save(p);
		}

		public void delete(Long id) {
		prepo.deleteById(id);
		}
	
}
