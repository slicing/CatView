package com.example.demo.controller;

import com.example.demo.bean.Product;
import com.example.demo.dao.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    ProductDao productDao;
    @PostMapping(value = "/hello")
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map = new HashMap<>();
        map.put("action","hello");
        map.put("name",name);

        logger.info(name + " said happy national day");

        return map;
    }

    @GetMapping("/product/get/{id}")
    public Product get(@PathVariable Integer id){
        return productDao.findById(id);
    }
    @GetMapping("/product/get/name/{name}")
    public Product getByName(@PathVariable String name){
        return productDao.findByName(name);
    }


    @PostMapping("/product/add/{name}/{price}")
    public int insert(@PathVariable String name,@PathVariable double price){
        Product product = new Product(name,price);
        return productDao.insert(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public int delete(@PathVariable Integer id){
        return productDao.delete(id);
    }

    @DeleteMapping("/product/delete/name/{name}")
    public int deleteByName(@PathVariable String name){
        Product product = productDao.findByName(name);
        return productDao.delete(product.getId());
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }


    @PutMapping("/product/update/{id}")
    public int updateById(@RequestParam String name,@RequestParam double price,@PathVariable int id){
        Product product = productDao.findById(id);
        product.setName(name);
        product.setPrice(price);
        return productDao.update(product);
    }

}
