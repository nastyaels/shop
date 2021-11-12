package com.eliseeva.shop.orders;

import com.eliseeva.shop.rest.dto.Order;
import com.eliseeva.shop.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderEntity addNewOrder(Order order, UserEntity user){
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setDeliveryTime(order.getDeliveryDate());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setStatus(order.getOrderStatus());
        orderEntity.setUser(user);
        return orderRepository.saveAndFlush(orderEntity);
    }
}
