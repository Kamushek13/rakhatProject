package com.java.rakhatProject.service;

import com.java.rakhatProject.entity.*;
import com.java.rakhatProject.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final AuthRepository authRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderItemService orderItemService;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, AuthRepository authRepository, CustomerRepository customerRepository, OrderItemRepository orderItemRepository, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.authRepository = authRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderItemService = orderItemService;
    }

    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }


    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order create(String tokenOfAccount, OrderProducts listProducts) {
        ArrayList<Long> productIDs = listProducts.getId();
        ArrayList<Integer> productQuantities = listProducts.getQuantity();
        float price = 0;
        for (long id: productIDs) {
            Product pr = productRepository.findByProductId(id);
            price += pr.getPrice() * productQuantities.get((int) id);
        }
        Auth auth = authRepository.findByToken(tokenOfAccount);
        Customer customer = customerRepository.findByCustomerId(auth.getCustomerId());

        String token = UUID.randomUUID().toString();

        orderRepository.insertOrder(auth.getCustomerId(), price, customer.getAddress(), 0, 0, 0, "Ordered", token);

        orderItemService.createOrderItem(token, productIDs, productQuantities);

        return orderRepository.findByToken(token);

    }

    public List<Order> getCustomerOrder(String tokenOfAccount) {
        Auth auth = authRepository.findByToken(tokenOfAccount);
        List<Order> listOrder = orderRepository.findByCustomerId(auth.getCustomerId());
        return orderItemService.getCustomerOrder(listOrder);
    }

    public Object getOrders() {
        List<Order> listOrder = (List<Order>) orderRepository.findAll();
        return orderItemService.getOrder(listOrder);
    }

    public Order changeStatus(String orderToken) {
        Order order = orderRepository.findByToken(orderToken);
        if (order.getStatus().equals("Ordered")){
            order.setStatus("Shipmented");
        } else if (order.getStatus().equals("Shipmented")){
            order.setStatus("Delivered");
        }

        return orderRepository.save(order);
    }

    public List<Order> getByStatusId(Long statusId) {
        return orderRepository.findAllByStatusId(statusId);
    }

}
