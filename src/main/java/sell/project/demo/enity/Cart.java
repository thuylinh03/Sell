package sell.project.demo.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Products products;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "shopping_cartID", referencedColumnName =
    // "shopping_cartID")
    // private Shopping_Cart cart;

    @Column(name = "quantity")
    private int quantity;

    public Cart() {
    }

    // @Override
    // public String toString() {
    // return "Cart [id=" + id + ", user=" + user + ", products=" + products + ",
    // cart=" + cart + ", quantity="
    // + quantity + "]";
    // }

    public Cart(int id, User user, Products products, int quantity) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.quantity = quantity;
    }

    // public Cart(int id, User user, Products products, Shopping_Cart cart, int
    // quantity) {
    // this.id = id;
    // this.user = user;
    // this.products = products;
    // this.cart = cart;
    // this.quantity = quantity;
    // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // public Shopping_Cart getCart() {
    // return cart;
    // }

    // public void setCart(Shopping_Cart cart) {
    // this.cart = cart;
    // }

}
