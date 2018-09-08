package com.dharma.springmvc.controller;

import com.dharma.springmvc.model.Product;
import com.dharma.springmvc.service.IProduceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class HiController {
    @Autowired
    IProduceService produceService;
    @GetMapping("/")
    public ResponseEntity<String> Hi(){
        return new ResponseEntity<String>("First rest api ", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = produceService.getProducts();
        if(products.isEmpty()){
            new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id){
        System.out.println("Fetching Product which id =" + id);
        Product product = produceService.getProduct(id);
        if(product == null){
            System.out.println("Fetching Product which id =" + id + "not find");
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/product")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResponseEntity<Void> CreateProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder){
        System.out.println("Adding Product" + product.getName());
        if(produceService.isProductExits(product)){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        produceService.addProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }
}
