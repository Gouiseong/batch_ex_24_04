package com.koreait.exam.batch_ex_24_04.app.order.repository;

import com.koreait.exam.batch_ex_24_04.app.order.entity.Order;
import com.koreait.exam.batch_ex_24_04.app.order.entity.OrderItem;
import com.koreait.exam.batch_ex_24_04.app.order.entity.RebateOrderItem;
import com.koreait.exam.batch_ex_24_04.app.product.entity.ProductBackup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RebateOrderItemRepository extends JpaRepository<RebateOrderItem, Long> {
    Optional<RebateOrderItem> findByOrderItemId(Long orderItemId);
}