package cart.service;

import cart.model.CartItem;
import cart.model.Product;
import cart.model.ShoppingCart;
import cart.repository.CartItemRepository;
import cart.repository.ProductRepository;
import cart.repository.ShoppingCartRepository;
import cart.spring.CustomExceptionBadRequest;
import cart.spring.CustomExceptionNotFound;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CartItemRepository cartItemRepository;

  public ShoppingCart createShoppingCart() {
    return shoppingCartRepository.save(new ShoppingCart());
  }

  public Optional<ShoppingCart> getShoppingCartById(Integer shoppingCartId) {
    return shoppingCartRepository.findById(shoppingCartId);
  }

  public Iterable<ShoppingCart> findAll() {
    return shoppingCartRepository.findAll();
  }

  public ShoppingCart addProductToCart(Integer shoppingCartId, Integer productId, Integer quantity)
      throws CustomExceptionNotFound {
    ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId)
        .orElseThrow(() -> new CustomExceptionNotFound("Cart does not exist"));
    if (shoppingCart.isCheckout()) {
      throw new CustomExceptionNotFound("The cart is already checkout");
    }
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new CustomExceptionNotFound("Product does not exist"));
    addOrderToCart(new CartItem(product, quantity), shoppingCart);
    shoppingCart.setTotalCost(getTotalCost(shoppingCart));
    return shoppingCartRepository.save(shoppingCart);
  }

  public ShoppingCart deleteProductFromCart(Integer shoppingCartId, Integer productId)
      throws CustomExceptionNotFound {
    ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId)
        .orElseThrow(() -> new CustomExceptionNotFound("Cart does not exist"));
    if (shoppingCart.isCheckout()) {
      throw new CustomExceptionNotFound("The cart is already checkout");
    }
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new CustomExceptionNotFound("Product does not exist"));

    for (CartItem cartItem : shoppingCart.getCartItems()) {
      if (cartItem.getProduct().equals(product)) {
        shoppingCart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
        break;
      }
    }

    shoppingCart.setTotalCost(getTotalCost(shoppingCart));
    return shoppingCartRepository.save(shoppingCart);
  }

  //pasar a bucle for

  private Integer getTotalCost(ShoppingCart shoppingCart) {
    Integer total = 0;
    for (CartItem cartItem : shoppingCart.getCartItems()) {
      total+= cartItem.getQuantity()*cartItem.getProduct().getPrice();
    }
    shoppingCart.setTotalCost(total);
    return shoppingCart.getTotalCost();
  }

  private Integer getTotalCost2(ShoppingCart shoppingCart) {
    return shoppingCart.getCartItems()
        .stream()
        .mapToInt(cartItem -> cartItem.getQuantity() * cartItem.getProduct().getPrice())
        .sum();
  }

  public ShoppingCart changeQuantityOfProducts(Integer shoppingCartId, Integer productId,
      Integer quantity) throws CustomExceptionNotFound {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new CustomExceptionNotFound("Product does not exist"));
    CartItem cartItem = cartItemRepository.findCartItemByProduct(product);
    cartItem.setQuantity(quantity);
    cartItemRepository.save(cartItem);

    ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId)
        .orElseThrow(() -> new CustomExceptionNotFound("Cart does not exist"));
    shoppingCart.setTotalCost(getTotalCost(shoppingCart));
    return shoppingCartRepository.save(shoppingCart);
  }

  public void addOrderToCart(CartItem cartItem, ShoppingCart shoppingCart) {
    if (existingProduct(cartItem, shoppingCart)) {
      shoppingCart.getCartItems().add(cartItem);
    }
    cartItem.setShoppingCart(shoppingCart);
  }

  private boolean existingProduct(CartItem cartItem, ShoppingCart shoppingCart) {
    for (CartItem listOfOrders : shoppingCart.getCartItems()) {
      if (listOfOrders.getProduct().equals(cartItem.getProduct())) {
        listOfOrders.setQuantity(listOfOrders.getQuantity() + cartItem.getQuantity());
        return false;
      }
    }
    return true;
  }

  public ShoppingCart checkoutCart(Integer shoppingCartId) throws CustomExceptionBadRequest {
    ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId)
        .orElseThrow(() -> new CustomExceptionBadRequest("Cart does not exist"));
    if (shoppingCart.isCheckout()) {
      throw new CustomExceptionBadRequest("The cart is already checkout");
    } else {
      shoppingCart.setCheckout(true);
    }
    return shoppingCartRepository.save(shoppingCart);
  }
}