package com.java.rakhatProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "weight")
    private double weight;

    @Column(name = "price")
    private double price;

    @Column(name = "order_id")
    private long orderId;

    @Transient
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
