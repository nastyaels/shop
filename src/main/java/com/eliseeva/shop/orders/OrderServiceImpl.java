package com.eliseeva.shop.orders;

import com.eliseeva.shop.exceptions.CakeNotFoundException;
import com.eliseeva.shop.purchase.PurchaseEntity;
import com.eliseeva.shop.rest.dto.*;
import com.eliseeva.shop.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Orders getOrders() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<Order> orderList = orderEntityList.stream().map(o -> {
            Order order = new Order();
            order.setId(o.getId());
            order.setDelivery(o.getDelivery());
            order.setOrderStatus(o.getStatus());
            order.setPayment(o.getPayment());
            order.setDeliveryAddress(o.getDeliveryAddress());
            order.setUserId(o.getUser().getId());
            order.setDeliveryDate(o.getDeliveryTime());
            return order;
        }).collect(Collectors.toList());
        Orders orders = new Orders();
        orders.setOrderList(orderList);
        return orders;
    }

    @Override
    public OrderEntity addNewOrder(Order order, UserEntity user) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setDeliveryTime(order.getDeliveryDate());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setStatus(order.getOrderStatus());
        orderEntity.setUser(user);
        return orderRepository.saveAndFlush(orderEntity);
    }
    @Override
    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }
    @Override
    public void editOrder(Order order){
        OrderEntity orderEntity = orderRepository.getById(order.getId());

        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setDeliveryTime(order.getDeliveryDate());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setStatus(order.getOrderStatus());

        orderRepository.saveAndFlush(orderEntity);
    }
}
