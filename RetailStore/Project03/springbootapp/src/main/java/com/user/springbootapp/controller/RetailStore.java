package com.user.springbootapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.springbootapp.model.Product;
import com.user.springbootapp.service.StoreService;

@RestController
@RequestMapping("/shop")
public class RetailStore {
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping
	public Product CreateProduct(@RequestBody Product product) {
		return storeService.CreateProduct(product);
	}
	
	@GetMapping
	public Collection<Product> GetProducts(){
		return storeService.GetProducts();
	}
	
	@GetMapping("/{productId}")
	public Product GetProductById(@PathVariable("productId") Integer productId) {
		return storeService.GetProductById(productId);
	}
	
	
	@GetMapping("/{productId}/{newPrice}")
	public Product EditProductPrice(@PathVariable("productId") Integer productId, @PathVariable("newPrice") Double productPrice) {
		return storeService.EditProductPrice(productId, productPrice);
	}
	
	
	@DeleteMapping("/{productId}")
	public void DeleteProductById(@PathVariable("productId") Integer productId) {
		storeService.DeleteProductById(productId);
		}
	
}
