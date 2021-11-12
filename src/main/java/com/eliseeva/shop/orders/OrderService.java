package com.eliseeva.shop.orders;

import com.eliseeva.shop.rest.dto.Order;
import com.eliseeva.shop.users.UserEntity;

public interface OrderService {
    OrderEntity addNewOrder(Order order, UserEntity user);
}
