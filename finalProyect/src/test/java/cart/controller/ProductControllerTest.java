package cart.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import cart.model.Product;
import cart.service.ProductService;
import cart.spring.ResourceNotFoundException;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

  @InjectMocks
  ProductController productController;
  @Mock
  public ProductService productService;


  @Before
  public void setUp() throws Exception {
    productController = new ProductController();
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void addNewProduct() {
    Product product = new Product();
    product.setName("apple");
    product.setCategory("fruits");
    product.setPrice(38);
    when(productService.createProduct(any())).thenReturn(product);
    Product result = productController.addNewProduct(product);
    assertEquals("apple", result.getName());
    assertEquals("fruits", result.getCategory());
    assertEquals(38, (long) result.getPrice());
  }

  @Test
  public void getProductById() {
    Product p = new Product();
    p.setProductId(123);
    when(productService.findById(any())).thenReturn(Optional.of(p));
    Product product = productController.getProductById(123);
    assertEquals(123, (long) product.getProductId());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void getProductByIdNotFound() {
    when(productService.findById(any())).thenReturn(Optional.empty());
    productController.getProductById(666);
  }

  @Test
  public void getAllProducts() {
  }

  @Test
  public void getProductByNameAndCategory() {
  }

  @Test
  public void updateProduct() {
  }

  @Test
  public void deleteProduct() {
  }
}