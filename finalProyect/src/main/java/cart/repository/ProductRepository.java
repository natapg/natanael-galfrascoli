package cart.repository;

import cart.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findByName(String name);
  List<Product> findByNameAndCategory(String name,String category);
  List<Product> findByCategory(String category);
}