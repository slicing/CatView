package com.slicing.springbootdemo.controller;

import com.slicing.springbootdemo.bean.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Value(value = "${dharma.title}")
    private String title;

    @Value(value = "${dharma.teacher}")
    private String teacher;

    @Value(value = "${dharma.project}")
    private String project;

    @Value(value = "${dharma.number}")
    private Integer number;

    @Value("#{product}")
    private Product product;

    @RequestMapping
    public String home(){
        logger.info("this is a log test info");
        logger.error("this is a log error");
        return "welcome slicing boot";
    }

    @Bean
    public Product product(){
        return new Product("taank",1,50);
    }

    @GetMapping("/get")//http://localhost:8080/home/get?name=xxx
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("teacher",teacher);
        map.put("project",project);
        map.put("number",number);
        map.put("name",name);
        map.put("product",product);
        return map;
    }

    @GetMapping("/product/{name}/{count}")
    public Product getProduct(@PathVariable String name,@PathVariable double count ){
        return new Product(name,2,count);
    }

}
