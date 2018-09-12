package com.dharma.spring.controller;

import com.dharma.spring.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductContorller {
    private Map<Integer, Product> products = null;

    public ProductContorller(){
        products = new HashMap<>();
    }
    @GetMapping("/product/save")
    public String createProduct(Model model){
        return "productSave";
    }

    @ModelAttribute("product")
    public Product createProductModel(){
        return new Product();
    }

}
