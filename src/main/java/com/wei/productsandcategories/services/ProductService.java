package com.wei.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.productsandcategories.models.Product;
import com.wei.productsandcategories.repositories.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
// CRUD
	// ---------- READ ALL ---------- READ ALL ---------- READ ALL
	public List<Product> findProducts() {
		return productRepo.findAll();
	}
	
	
	// ---------- READ ONE ---------- READ ONE ---------- READ ONE
	public Product findProductById(Long productId) {
		Optional<Product> optionalProduct = productRepo.findById(productId);
		
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	
	// ---------- CREATE and UPDATE for ONE product ---------- CREATE and UPDATE for ONE product
	public Product createAndUpdateProduct(Product product) {
		return productRepo.save(product);
	}
	
	
	// ---------- DELETE ONE
	public void deleteProduct(Long productId) {
		productRepo.deleteById(productId);
	}

}
