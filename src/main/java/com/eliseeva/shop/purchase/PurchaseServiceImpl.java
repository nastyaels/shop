package com.eliseeva.shop.purchase;

import com.eliseeva.shop.goods.CakeEntity;
import com.eliseeva.shop.orders.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository){ this.purchaseRepository = purchaseRepository; }

    @Override
    public void addPurchase(OrderEntity order, CakeEntity cake, Integer number){
        PurchaseEntity purchase = new PurchaseEntity();

        purchase.setCake(cake);
        purchase.setNumber(number);
        purchase.setOrder(order);
        purchaseRepository.saveAndFlush(purchase);
    }
}
