package com.dharma.spring.controller;

import com.dharma.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductContorller {
    private Map<Integer, Product> products = null;

    @Autowired
    @Qualifier("productValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    public ProductContorller(){

        products = new HashMap<>();
    }
    @GetMapping("/product/save")
    public String createProduct(){
        return "productSave";
    }

    @ModelAttribute("product")
    public Product createProductModel(){
        return new Product();
    }

    @PostMapping("/product/save.do")
    public String saveProduct(
            @ModelAttribute("product") @Validated Product product,
            BindingResult bindingResult,//验证结果
            Model model){
        if(bindingResult.hasErrors()){
            return "productSave";
        }
        products.put(product.getId(),product);
        return "success";
    }

}
