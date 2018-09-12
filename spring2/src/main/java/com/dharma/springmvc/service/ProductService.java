package com.dharma.springmvc.service;

import com.dharma.springmvc.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService implements IProduceService{
    private static final AtomicLong counter = new AtomicLong();

    private static List<Product> products;
    static {
        products = initData();
    }

    private static List<Product> initData() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(counter.incrementAndGet(),"可乐",2.5,100));
        products.add(new Product(counter.incrementAndGet(),"雪碧",3,300));
        products.add(new Product(counter.incrementAndGet(),"巧克力",50,50));
        products.add(new Product(counter.incrementAndGet(),"饼干",7,400));
        products.add(new Product(counter.incrementAndGet(),"雪糕",20,500));
        return products;

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }


    @Override
    public Product getProduct(long id){
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
            if(p.getName().equalsIgnoreCase(product.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Product product) {
        //product.setId(counter.incrementAndGet());
        products.add(product);
    }

    @Override
    public Product updateProduct(Product product) {
        for(Product p : products){
            if(p.getId() == product.getId()){
                p.setName(product.getName());
                p.setCount(product.getCount());
                p.setPrice(product.getPrice());
            }
        }
        return product;
    }

    @Override
    public boolean deleteProduct(final long id) {
        return products.removeIf((product) -> product.getId() == id);
    }


}
