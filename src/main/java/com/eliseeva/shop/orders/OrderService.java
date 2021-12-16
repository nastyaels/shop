package com.eliseeva.shop.orders;

import com.eliseeva.shop.rest.dto.Order;
import com.eliseeva.shop.rest.dto.Orders;
import com.eliseeva.shop.users.UserEntity;

public interface OrderService {
    Orders getOrders();
    OrderEntity addNewOrder(Order order, UserEntity user);
    void deleteOrderById(Long id);
    void editOrder(Order order);
}
