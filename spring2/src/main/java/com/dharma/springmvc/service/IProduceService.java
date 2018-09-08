package com.dharma.springmvc.service;

import com.dharma.springmvc.model.Product;

import java.util.List;

public interface IProduceService {
    List<Product> getProducts();
    Product getProduct(long id);
    boolean isProductExits(Product product);
    void addProduct(Product product);

}
