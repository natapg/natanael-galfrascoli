package cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping(path = "/add")
  String addNewProduct(@RequestParam String name, @RequestParam String category,
      @RequestParam double price) {
    Product n = new Product();
    n.setName(name);
    n.setCategory(category);
    n.setPrice(price);
    productRepository.save(n);
    return String
        .format("The item %s of the category %s with the price of $ %.2f has been added", name,
            category, price);
  }

  @GetMapping(path = "/all")
  Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }

}

