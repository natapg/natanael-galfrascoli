package cart.repository;

import cart.model.CartItem;
import cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
  CartItem findCartItemByProduct(Product product);

}
