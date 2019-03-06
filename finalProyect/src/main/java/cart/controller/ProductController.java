package cart.controller;

import cart.model.Product;
import cart.service.ProductService;
import cart.spring.CustomExceptionNotFound;
import cart.spring.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/product")
@Api(value = "Product shopping cart", description = "Operations pertaining to products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @ApiOperation(value = "Add a product")
  @PostMapping
  public Product addNewProduct(@Valid @RequestBody Product n) {
    return productService.createProduct(n);
  }

  @ApiOperation(value = "Get a product by id")
  @GetMapping(value = "/{id}")
  public Product getProductById(@PathVariable(value = "id") Integer productId) {
    return productService.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
  }

  @ApiOperation(value = "View a list of all products", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list")
  })
  @GetMapping(value = "/all")
  Iterable<Product> getAllProducts() {
    return productService.findAll();
  }

  @ApiOperation(value = "View a list of products by name", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  })
  @GetMapping
  List<Product> getProductByNameAndCategory(
      @RequestParam(required = false, name = "name") String name,
      @RequestParam(required = false, name = "category") String category) {
    if (name == null && category == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Category and/or name is required ");
    }
    return productService.findByNameAndCategory(name, category);
  }

  @ApiOperation(value = "Modify a product, specified by product ID")
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable(value = "id") Integer productId,
      @RequestBody Product product)
      throws CustomExceptionNotFound {
    return productService.updateProduct(productId, product);
  }

  @ApiOperation(value = "Deletes a product, specified by product ID")
  @DeleteMapping("/{id}")
  void deleteProduct(@PathVariable(value = "id") Integer productId) throws CustomExceptionNotFound {
    productService.deleteProductById(productId);
  }
}

