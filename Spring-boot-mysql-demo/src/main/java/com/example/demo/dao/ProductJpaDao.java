package com.example.demo.dao;

import com.example.demo.bean.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductJpaDao extends CrudRepository<Product,Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndPrice(String name,double price);
}
