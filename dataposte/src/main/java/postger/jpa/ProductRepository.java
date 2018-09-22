package postger.jpa;



import org.springframework.data.repository.CrudRepository;
import postger.model.Product;



public interface ProductRepository extends CrudRepository<Product,Integer> {

}
