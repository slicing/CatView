package com.example.demo.controller;

import com.example.demo.bean.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String index(ModelMap map){
        map.put("title","GUO QING KUAI LE");
        return "index";
    }

    @GetMapping("/upload")
    public String upload(ModelMap map){
        return "upload";
    }

    @GetMapping("/product")
    public String product(ModelMap map){
        List<Product> products = productService.getProducts();
        map.put("product",products);
        return "product";
    }

    @RequestMapping("/error")
    public void error(
            @RequestParam Integer a,
            @RequestParam Integer b,
            ModelMap map){
        try{
            Integer c = a/b;
            map.addAttribute("result",c);
        }catch (Exception e){
            throw new RuntimeException("devision exception");
        }
    }



}
