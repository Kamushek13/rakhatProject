package com.java.rakhatProject.service;

import com.java.rakhatProject.entity.Order;
import com.java.rakhatProject.entity.OrderItem;
import com.java.rakhatProject.entity.Product;
import com.java.rakhatProject.repository.OrderItemRepository;
import com.java.rakhatProject.repository.OrderRepository;
import com.java.rakhatProject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService{
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public OrderItemService(OrderItemRepository orderItemRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;

    }

    public List<OrderItem> getAll() {
        return (List<OrderItem>) orderItemRepository.findAll();
    }


    public OrderItem save(OrderItem item) {
        return orderItemRepository.save(item);
    }

    public void createOrderItem(String token, ArrayList<Long> productIDs, ArrayList<Integer> productQuantities) {
        Order order = orderRepository.findByToken(token);
        for (Long id: productIDs) {
            Product pr = productRepository.findByProductId(id);
            float price = pr.getPrice() * productQuantities.get(Math.toIntExact(id));
            float weight = (float) pr.getWeight() * productQuantities.get(Math.toIntExact(id));
            orderItemRepository.insertOrderItems(id, order.getId(), productQuantities.get(Math.toIntExact(id)), weight, price, order.getStatus());
            pr.setStock(pr.getStock() - productQuantities.get(Math.toIntExact(id)));
            productRepository.save(pr);
        }
    }

    public List<Order> getCustomerOrder(List<Order> listOrder) {
        for (Order order: listOrder) {
            List<OrderItem> list = orderItemRepository.findByOrderId(order.getId());
            for (OrderItem oi : list) {
                oi.setProduct(productRepository.findByProductId(oi.getProductId()));
            }
            order.setOrderItemList(list);
        }
        return listOrder;
    }

    public List<Order> getOrder(List<Order> listOrder) {
        for (Order order: listOrder) {
            List<OrderItem> list = orderItemRepository.findByOrderId(order.getId());
            for (OrderItem oi : list) {
                oi.setProduct(productRepository.findByProductId(oi.getProductId()));
            }
            order.setOrderItemList(list);
        }
        return listOrder;
    }
}

