package cart.controller;

import cart.model.ShoppingCart;
import cart.service.ShoppingCartService;
import cart.spring.CustomExceptionBadRequest;
import cart.spring.CustomExceptionNotFound;
import cart.spring.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingcart")
public class ShoppingCartController {

  @Autowired
  private ShoppingCartService shoppingCartService;

  @ApiOperation(value = "Create a cart")
  @PostMapping
  public ShoppingCart createACart() {
    return shoppingCartService.createShoppingCart();
  }

  @ApiOperation(value = "Add a product to cart")
  @PutMapping(path = "/{cartId}/product/{productId}")
  public ResponseEntity<ShoppingCart> addProductToCart(@PathVariable("cartId") Integer cartId,
      @PathVariable("productId") Integer productId, @RequestParam("quantity") Integer quantity)
      throws CustomExceptionNotFound {
    ShoppingCart shoppingCart = shoppingCartService.addProductToCart(cartId, productId, quantity);
    return new ResponseEntity<>(shoppingCart, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Get a cart by id")
  @GetMapping(value = "/{cartId}")
  public ShoppingCart getCartById(@PathVariable(value = "cartId") Integer shoppingCartId) {
    return shoppingCartService.getShoppingCartById(shoppingCartId)
        .orElseThrow(() -> new ResourceNotFoundException("Product", "id", shoppingCartId));
  }

  @ApiOperation(value = "View a list of all carts", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list")
  })
  @GetMapping(value = "/all")
  Iterable<ShoppingCart> getAllShoppingCarts() {
    return shoppingCartService.findAll();
  }

  @ApiOperation(value = "Deletes a product from a cart specified by product ID")
  @DeleteMapping("/{cartId}/product/{productId}")
  void deleteProductFromCart(@PathVariable(value = "cartId") Integer cartId,
      @PathVariable(value = "productId") Integer productId)
      throws CustomExceptionNotFound {
    shoppingCartService.deleteProductFromCart(cartId, productId);
  }

  @ApiOperation(value = "Change quantity of product in a cart specified by cart ID")
  @PutMapping(path = "/{cartId}/productQuantity/{productId}")
  public ResponseEntity<ShoppingCart> changeQuantityOfProducts(
      @PathVariable("cartId") Integer cartId,
      @PathVariable("productId") Integer productId, @RequestParam("quantity") Integer quantity)
      throws CustomExceptionNotFound {
    ShoppingCart shoppingCart = shoppingCartService
        .changeQuantityOfProducts(cartId, productId, quantity);
    return new ResponseEntity<>(shoppingCart, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Checkout a cart specified by cart ID")
  @PutMapping(path = "/{cartId}/checkout")
  public ResponseEntity<ShoppingCart> changeQuantityOfProducts(
      @PathVariable("cartId") Integer cartId)
      throws CustomExceptionBadRequest {
    ShoppingCart shoppingCart = shoppingCartService
        .checkoutCart(cartId);
    return new ResponseEntity<>(shoppingCart, HttpStatus.CREATED);
  }

}
