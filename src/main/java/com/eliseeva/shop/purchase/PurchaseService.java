package com.eliseeva.shop.purchase;

import com.eliseeva.shop.goods.CakeEntity;
import com.eliseeva.shop.orders.OrderEntity;


public interface PurchaseService {
    void addPurchase(OrderEntity order, CakeEntity cake, Integer number);
}
