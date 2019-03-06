package cart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CART_ITEMS")
public class CartItem {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_CARTITEM")
  private Integer cartItemId;

  @ManyToOne
  @JoinColumn(name = "FK_PRODUCT_ID")
  private Product product;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "FK_CART_ID")
  private ShoppingCart shoppingCart;

  @Column(name = "QUANTITY")
  private Integer quantity;

  public Integer getCartItemId() {
    return cartItemId;
  }

  public void setCartItemId(Integer cartItemId) {
    this.cartItemId = cartItemId;
  }

  public CartItem() {
  }

  public CartItem(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }


  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }
}
