package com.bel.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="custproducts")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
    private String productName;
    private Double price;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="Cust_ID")
    private Customer customer;
	
}
