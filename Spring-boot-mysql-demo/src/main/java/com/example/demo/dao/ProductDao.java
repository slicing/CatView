package com.example.demo.dao;

import com.example.demo.bean.Product;

import java.util.List;

//数据库    --   对象   --   操作数据库的 ----
public interface ProductDao {
    Product findById(int id);

    Product findByName(String name);

    int insert(Product product);

    int update(Product product);

    int delete(int id);

    List<Product> findAll();
}
