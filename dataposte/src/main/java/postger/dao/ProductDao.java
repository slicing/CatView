package postger.dao;

import org.springframework.beans.factory.annotation.Autowired;
import postger.jpa.ProductRepository;
import postger.model.Product;

public class ProductDao {
    @Autowired
    private ProductRepository repository;

    public Product getProduct(int id){
        return repository.findOne(id);
    }

}
