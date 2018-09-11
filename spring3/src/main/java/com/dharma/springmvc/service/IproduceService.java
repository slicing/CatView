package com.dharma.springmvc.service;

import com.dharma.springmvc.model.Product;

import java.util.List;

public interface IproduceService {
	List<Product> getProducts();
	Product getProduct(long id);
	boolean isProductExits(Product product);
	void addProduct(Product product);
	Product getProductById(long id);
	void updateProduct(Product product);
	Product getProductByName(String name);
	void delProduct(Product p);

}
