package com.eliseeva.shop.rest.controller;

import com.eliseeva.shop.goods.CakesService;
import com.eliseeva.shop.orders.OrderService;
import com.eliseeva.shop.rest.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cakes_jdbc_t")
public class ControllerJdbcTemplate {

    private final CakesService cakesService;
    private final OrderService orderService;
    @Autowired
    public ControllerJdbcTemplate(CakesService cakesService, OrderService orderService) {
        this.cakesService = cakesService;
        this.orderService = orderService;
    }
    @PostMapping()
    public void addCake(@RequestBody InfoAboutCake cake){
        cakesService.addCake(cake);
    }
    @GetMapping("/{id}")
    public Cake getCakeById(@PathVariable Long id){
        return cakesService.getCakeById(id);
    }
    @GetMapping()
    public Cakes getListOfCakes(){
        return cakesService.getCakes();
    }
    @PatchMapping("/{id}")
    public void editCake(@PathVariable Long id, @RequestBody InfoAboutCake infoAboutCake){
        cakesService.editCake(id,infoAboutCake);

    }
    @DeleteMapping("/{id}")
    public void deleteCakeById(@PathVariable Long id){
        cakesService.deleteCakeById(id);
    }

    @PostMapping("/order")
    public void addOrder(@RequestBody Order order){
        orderService.addNewOrder(order);
    }
}
