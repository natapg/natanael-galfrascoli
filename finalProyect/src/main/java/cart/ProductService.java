package cart;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  Optional<Product> findById(Integer productId) {
    return productRepository.findById(productId);
  }

  Product save(Product n) {
    return productRepository.save(n);
  }

  Iterable<Product> findAll() {
    return productRepository.findAll();
  }
}
