package com.example.demo.service;

import com.example.demo.bean.Product;
import com.example.demo.dao.ProductJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductJpaDao productJpaDao;

    public List<Product> getProducts(){
        return (List<Product>) productJpaDao.findAll();
    }


    public Product getById(int id){
        return productJpaDao.findOne(id);
    }


    public List<Product> getProductsByName(String name){
        return productJpaDao.findByName(name);
    }

    public List<Product>  getProductByNameId(String name,double price){
        return productJpaDao.findByNameAndPrice(name,price);
    }

    public Product addProduct(String name,double price){
        return productJpaDao.save(new Product(name,price));
    }


    public Product updateProduct(int id,String name,double price){
        return productJpaDao.save(new Product(id,name,price));
    }

    public void deleteProduct(int id){
        productJpaDao.delete(id);
    }
}
