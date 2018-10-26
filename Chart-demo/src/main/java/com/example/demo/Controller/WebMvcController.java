package com.example.demo.Controller;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
public class WebMvcController extends WebMvcConfigurationSupport {
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/ws").setViewName("/ws");
	}
}
