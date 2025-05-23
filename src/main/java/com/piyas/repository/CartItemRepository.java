package com.piyas.repository;

import com.piyas.model.Cart;
import com.piyas.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


}
