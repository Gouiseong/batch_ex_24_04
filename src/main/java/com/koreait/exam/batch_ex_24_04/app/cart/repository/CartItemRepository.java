package com.koreait.exam.batch_ex_24_04.app.cart.repository;

import com.koreait.exam.batch_ex_24_04.app.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}