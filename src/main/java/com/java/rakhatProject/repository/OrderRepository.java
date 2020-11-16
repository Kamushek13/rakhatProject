package com.java.rakhatProject.repository;

import com.java.rakhatProject.entity.Order;
import com.java.rakhatProject.entity.Product;
import com.java.rakhatProject.entity.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    @Transactional
    @Modifying
    @Query(
            value = "insert into orders (customer_id, total_price, address, order_date, shipment_date, delivery_date, status, token) values (:customer_id, :total_price, :address, :order_date, :shipment_date, :delivery_date, :status, :token)",
            nativeQuery = true)
    void insertOrder(@Param("customer_id") long customerId, @Param("total_price") float total_price,
                             @Param("address") String address, @Param("order_date") long order_date, @Param("shipment_date") long shipment_date, @Param("delivery_date") long delivery_date,  @Param("status") String status, @Param("token") String token);


    Order findByToken(String token);

    List<Order> findByCustomerId(long id);
///HERE
    List<Order> findAllByStatusId(Long statusId);

    Status findByStatusId(long id);


}
