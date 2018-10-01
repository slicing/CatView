package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    @PostMapping(value = "/hello")
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map = new HashMap<>();
        map.put("action","hello");
        map.put("name",name);

        logger.info(name + " said happy national day");

        return map;
    }

}
