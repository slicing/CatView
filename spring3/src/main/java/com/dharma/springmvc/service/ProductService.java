package com.dharma.springmvc.service;

import com.dharma.springmvc.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService implements IproduceService{
	private static final AtomicLong counter = new AtomicLong();
	private static List<Product> products;
	static {
		products = initData();
	}

	private static List<Product> initData() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(counter.incrementAndGet(),"可乐",2.5,100));
		products.add(new Product(counter.incrementAndGet(),"雪碧",3,500));
		products.add(new Product(counter.incrementAndGet(),"巧克力",20,200));
		products.add(new Product(counter.incrementAndGet(),"饼干",7,500));
		products.add(new Product(counter.incrementAndGet(),"亦能",4,400));
		return products;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Product getProduct(long id) {
		for(Product p : products){
			if(p.getId() == id){
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean isProductExits(Product product) {
		for(Product p :products){
			if(p.getName().equals(product.getName())){
				return true;
			}
		}
		return false;
	}

	@Override
	public void addProduct(Product product) {
		product.setId(counter.incrementAndGet());
		products.add(product);
	}

	@Override
	public Product getProductById(long id) {
		for(Product p : products){
			if(p.getId() == id){
				return   p;
			}
		}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index,product);
	}

	@Override
	public Product getProductByName(String name) {
		for(Product p : products){
			if(p.getName().equals(name)){
				return  p;
			}
		}
		return null;
	}

	@Override
	public void delProduct(Product p) {
		products.remove(p);
	}
}
