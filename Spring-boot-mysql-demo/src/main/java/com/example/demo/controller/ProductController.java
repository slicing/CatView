package com.example.demo.controller;

import com.example.demo.bean.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public List<Product> getAll(){
        return productService.getProducts();
    }

    @GetMapping("/get/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }


    @GetMapping("/{name}")
    public List<Product> getByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }


    @GetMapping("/{name}/{price}")
    public List<Product> getByNamePrice(@PathVariable String name,@PathVariable double price){
        return productService.getProductByNameId(name,price);
    }


    @PostMapping("/{name}/{price}")
    public Product addProduct(@PathVariable String name,@PathVariable double price){
        return productService.addProduct(name,price);
    }

    @PutMapping("/{id}/{name}/{price}")
    public Product updateProduct(@PathVariable int id,@PathVariable String name,@PathVariable double price){
        return productService.updateProduct(id,name,price);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
