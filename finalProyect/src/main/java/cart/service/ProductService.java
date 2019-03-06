package cart.service;

import cart.model.Product;
import cart.repository.ProductRepository;
import cart.spring.CustomExceptionNotFound;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Optional<Product> findById(Integer productId) {
    return productRepository.findById(productId);
  }

  public List<Product> findByNameAndCategory(String name, String category) {
    if (name != null && category != null) {
      return productRepository.findByNameAndCategory(name, category);
    } else if (name != null) {
      return productRepository.findByName(name);
    } else {
      return productRepository.findByCategory(category);
    }
  }

  public Product createProduct(Product n) {
    return productRepository.save(n);
  }

  public Iterable<Product> findAll() {
    return productRepository.findAll();
  }

  public void deleteProductById(Integer productId)throws CustomExceptionNotFound {
    Product productDelete = productRepository.findById(productId)
        .orElseThrow(() -> new CustomExceptionNotFound("Product not available to delete"));
    productRepository.deleteById(productId);
  }

  public Product updateProduct(Integer productId, Product product) throws CustomExceptionNotFound {
    Product productUpdated = productRepository.findById(productId)
        .orElseThrow(() -> new CustomExceptionNotFound("Product not available to update"));
    productUpdated.setName(product.getName());
    productUpdated.setPrice(product.getPrice());
    productUpdated.setCategory(product.getCategory());
    return productRepository.save(productUpdated);
  }
}
