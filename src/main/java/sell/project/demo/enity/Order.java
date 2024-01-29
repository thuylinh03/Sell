package sell.project.demo.enity;

import java.util.Date;

import org.hibernate.engine.internal.ForeignKeys;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Products products;

    @Column(name = "thanhtien")
    private float money;

    @Column(name = "orderDate")
    private Date datetime;

    public Order() {
    }

    public Order(int id, User user, Products products, float money, Date datetime) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.money = money;
        this.datetime = datetime;
    }

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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

}
