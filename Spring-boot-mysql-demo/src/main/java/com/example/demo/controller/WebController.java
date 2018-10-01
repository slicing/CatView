package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web")
public class WebController {
    @GetMapping("")
    public String index(ModelMap map){
        map.put("title","GUO QING KUAI LE");
        return "index";
    }

    @GetMapping("/upload")
    public String upload(ModelMap map){
        return "upload";
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
