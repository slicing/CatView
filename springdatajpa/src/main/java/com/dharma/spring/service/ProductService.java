package com.dharma.spring.service;

import com.dharma.spring.repositor.ProductRepository;
import com.dharma.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public Product getById(long id){
        return productRepository.findOne(id);
    }

    @Transactional
    public void deleteProduct(long productId){
        productRepository.delete(productId);
    }


    @Transactional
    public void deleteAllProduct(){
        productRepository.deleteAll();
    }

    @Transactional
    public boolean updataProduct(Product product){
        return productRepository.save(product)!= null;

    }

    @Transactional
    public List<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }

}
