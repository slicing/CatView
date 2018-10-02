package com.example.demo.dao;

import com.example.demo.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.PrivateKey;
import java.util.List;

@Repository
public class ProductDaoImpl implements  ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Product findById(int id) {
        String sql = "select * from product where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Product.class),id);
    }

    @Override
    public Product findByName(String name) {
        String sql = "select * from product where name=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Product.class),name);
    }

    @Override
    public int insert(Product product) {
        String sql = "insert into product(name,price) values(?,?)";
        return jdbcTemplate.update(sql,product.getName(),product.getPrice());
    }

    @Override
    public int update(Product product) {
        String sql = "update product set name=?,price=? where id=?";
        return jdbcTemplate.update(sql,product.getName(),product.getPrice(),product.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from product where id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Product> findAll() {
        String sql = "select * from product";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class));
    }
}
