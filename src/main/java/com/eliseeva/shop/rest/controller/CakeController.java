//package com.eliseeva.shop.rest.controller;
//
//import com.eliseeva.shop.goods.CakeRepository;
//import com.eliseeva.shop.goods.CakesService;
//import com.eliseeva.shop.orders.OrderEntity;
//import com.eliseeva.shop.orders.OrderService;
//import com.eliseeva.shop.purchase.PurchaseService;
//import com.eliseeva.shop.rest.dto.*;
//import com.eliseeva.shop.users.UserEntity;
//import com.eliseeva.shop.users.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping(value = "/user")
//public class CakeController {
//    private final CakesService cakesService;
//    private final PurchaseService purchaseService;
//    private final UserService userService;
//    private final OrderService orderService;
//    private final CakeRepository cakeRepository;
//
//    private final Cakes cakeList = new Cakes();
//
//    @Autowired
//    public CakeController(CakesService cakesService, PurchaseService purchaseService, OrderService orderService, UserService userService, CakeRepository cakeRepository) {
//        List<Cake> tmp = new ArrayList<Cake>();
//        cakeList.setCakeList(tmp);
//        this.cakesService = cakesService;
//        this.purchaseService = purchaseService;
//        this.orderService = orderService;
//        this.userService = userService;
//        this.cakeRepository = cakeRepository;
//
//    }
//
//    @GetMapping(value = "/cakes")
//    public String getListOfCakes(Model model) {
//        model.addAttribute("cakes",cakesService.getCakes().getCakeList());
//        model.addAttribute("cake", new InfoAboutCake());
//        cakeRepository.eByName("Medovik");
//        return "cakesUser";
//    }
//
//    @GetMapping(value = "cake/{id}")
//    public String getCakeById(@PathVariable Long id, Model model) {
//        model.addAttribute("cake",cakesService.getInfoAboutCake(id));
//        return "cake";
//    }
//
//}
