package com.java.rakhatProject.repository;

import com.java.rakhatProject.entity.OrderItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Long> {
    @Transactional
    @Modifying
    @Query(
            value = "insert into orderItem (product_id, order_id, quantity, weight, price, status) values (:product_id, :order_id, :quantity, :weight, :price, :status)",
            nativeQuery = true)
    void insertOrderItems(@Param("product_id") long product_id, @Param("order_id") long order_id,
                     @Param("quantity") long quantity, @Param("weight") float weight, @Param("price") float price, @Param("status") String status);

    List<OrderItem> findByOrderId(long id);
}
