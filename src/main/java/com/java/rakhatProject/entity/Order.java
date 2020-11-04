package com.java.rakhatProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "address")
    private String address;

    @Column(name = "order_date")
    private long orderDate;

    @Column(name = "shipment_date")
    private long shipmentDate;

    @Column(name = "delivery_date")
    private long deliveryDate;

    @Column(name = "status")
    private String status;

    @Column(name = "token")
    private String token;

    @Transient
    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
