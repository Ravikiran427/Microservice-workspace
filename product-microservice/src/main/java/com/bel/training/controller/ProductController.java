package com.bel.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bel.training.model.Product;
import com.bel.training.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService pService;

	
	@GetMapping(value ="/all")
	public ResponseEntity<List<Product>> findProducts(){
	return new ResponseEntity<>(pService.getProducts(), HttpStatus.OK);
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long pId){
	return new ResponseEntity<>(pService.get(pId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<Product>> addNewProduct(@RequestBody Product product){
	return new ResponseEntity<>(pService.saveProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long pId,@RequestBody Product pro){
	Product p = pService.get(pId);
	p.setPrice(pro.getPrice());
	Product updatedProduct = pService.updateProduct(pId, p);
	return ResponseEntity.ok().body(updatedProduct);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long pId){
	pService.delete(pId);
	return ResponseEntity.ok().body("Product Deleted.");
	}
}
