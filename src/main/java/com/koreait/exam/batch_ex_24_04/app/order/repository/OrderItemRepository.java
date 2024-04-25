package com.koreait.exam.batch_ex_24_04.app.order.repository;

import com.koreait.exam.batch_ex_24_04.app.order.entity.Order;
import com.koreait.exam.batch_ex_24_04.app.order.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Page<OrderItem> findAllByIdLessThan(long id, Pageable pageable);
    Page<OrderItem> findAllByIdBetween(long fromId, long toId, Pageable pageable);
    Page<OrderItem> findAllByIsPaid(boolean isPaid, Pageable pageable);
}
