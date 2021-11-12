package com.eliseeva.shop.rest.controller;

import com.eliseeva.shop.goods.CakesService;
import com.eliseeva.shop.orders.OrderEntity;
import com.eliseeva.shop.orders.OrderService;
import com.eliseeva.shop.purchase.PurchaseService;
import com.eliseeva.shop.rest.dto.*;
import com.eliseeva.shop.users.UserEntity;
import com.eliseeva.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class CakeController {
    private final CakesService cakesService;
    private final PurchaseService purchaseService;
    private final UserService userService;
    private final OrderService orderService;

    private static long idCounter = 0;
    private final Cakes cakeList = new Cakes();

    @Autowired
    public CakeController(CakesService cakesService, PurchaseService purchaseService, OrderService orderService, UserService userService) {
        List<Cake> tmp = new ArrayList<Cake>();
        cakeList.setCakeList(tmp);
        this.cakesService = cakesService;
        this.purchaseService = purchaseService;
        this.orderService = orderService;
        this.userService = userService;

    }

    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes getListOfCakes() {
        return cakesService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public InfoAboutCake getCakeById(@PathVariable Long id) {
        return cakesService.getInfoAboutCake(id);
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> addCake(@RequestBody @Valid Cake mcake) {
        if (mcake.getId() == null || mcake.getCalories() == null ||
                mcake.getImage() == null || mcake.getName() == null || mcake.getWeight() == null || mcake.getPrice() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            cakeList.getCakeList().add(mcake);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PostMapping(path = "addNewOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InfoAboutOrder> addOrder(@RequestBody @Valid InfoAboutOrder mOrder) {
        UserEntity user = userService.addUser(mOrder.getUser());
        OrderEntity order = orderService.addNewOrder(mOrder.getOrder(), user);
        for (Purchase purchase : mOrder.getPurchases())
            purchaseService.addPurchase(order, cakesService.getCakeEntity(purchase.getCakeId()), purchase.getNumber());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
