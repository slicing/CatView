package com.dharma.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HiController {
    @RequestMapping(method = RequestMethod.GET)
    public String Hi(ModelMap model){
        model.addAttribute("greeting","from Dharme team").addAttribute(888);
        System.out.println(model.toString());
        return "index";

    }
}
