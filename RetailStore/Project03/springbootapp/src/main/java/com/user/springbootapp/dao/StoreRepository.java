package com.user.springbootapp.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.user.springbootapp.model.Product;

@Component
public class StoreRepository {
	
	//ADD MORE REPOS HERE
	public Map<Integer, Product> ProductData = new HashMap<>();
	
	
	//PRODUCT CRUD OPERATIONS
	public Product CreateProduct(Product product) {
		
		Integer productId = ProductData.size()+1;
		product.setProductId(productId);
		ProductData.put(productId, product);
		
		return product;

	}


	public Collection<Product> GetProducts() {
		return ProductData.values();
	}


	public Product EditProductPrice(Integer productId, Double productPrice) {
		Product product = ProductData.get(productId);
		product.setProductPrice(productPrice);
		return product;
	}


	public Product GetProductById(Integer productId) {
		return ProductData.get(productId);
	}


	public void DeleteProductById(Integer productId) {
		ProductData.remove(productId);
	}
	

}
