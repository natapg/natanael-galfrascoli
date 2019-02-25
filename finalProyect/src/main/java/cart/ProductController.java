package cart;

import cart.spring.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api")
@Api(value = "Product shopping cart", description = "Operations pertaining to products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @ApiOperation(value = "Add a product")
  @PostMapping("/product")
  Product addNewProduct(@Valid @RequestBody Product n) {
    return productService.save(n);
  }

  @ApiOperation(value = "Get a product by id")
  @GetMapping(value = "product/{id}")
  public Product getProductById(@PathVariable(value = "id") Integer productId) {
    if (productId == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "id is requiered to find a product.");
    }
    return productService.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
  }

  @ApiOperation(value = "View a list of all products", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  })
  @GetMapping(path = "product")
  Iterable<Product> getAllProducts() {
    return productService.findAll();
  }

}

