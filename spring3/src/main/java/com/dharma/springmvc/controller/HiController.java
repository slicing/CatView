package com.dharma.springmvc.controller;

import com.dharma.springmvc.model.Product;
import com.dharma.springmvc.service.IproduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class HiController {
	@Autowired
	IproduceService produceService;
	@GetMapping("/")
	public ResponseEntity<String> Hi(){
		return new ResponseEntity<String>("Fist rest api",HttpStatus.NOT_FOUND);
	}

	//查询全部
	@GetMapping("/product/")
	public ResponseEntity<List<Product>>getProducts(){
		List<Product> products = produceService.getProducts();
		if(products.isEmpty()){
			new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	//查询某一个
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id){
		System.out.println("Fetching Product which id = " + id);
		Product product = produceService.getProduct(id);
		if(product == null){
			System.out.println("Fetching Product which id=" + id + "not find");
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	//增加
	@PostMapping("/product/")
	public ResponseEntity<Void> CreateProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder){
		System.out.println("Adding Product" + product.getName());
		if(produceService.isProductExits(product)){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		produceService.addProduct(product);
		HttpHeaders headers =new HttpHeaders();
		headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	//修改
	@PostMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product){
		System.out.println("Updataing Product" + id);
		Product product1 = produceService.getProductById(id);

		if(product1 == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		product1.setName(product.getName());
		product1.setCount(product.getCount());
		product1.setPrice(product.getPrice());

		produceService.updateProduct(product1);
		return new ResponseEntity<>(product1,HttpStatus.OK);
	}
	//删除
	@PostMapping("/product/del/")
	public ResponseEntity<Void> delProduct(@RequestBody Product p){
		System.out.println("del product" + p.getName());
		Product product = produceService.getProductByName(p.getName());
		if(product == null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		produceService.delProduct(product);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
}
