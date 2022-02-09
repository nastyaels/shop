//package com.eliseeva.shop.rest.controller;
//
//import com.eliseeva.shop.goods.CakesService;
//import com.eliseeva.shop.orders.OrderEntity;
//import com.eliseeva.shop.orders.OrderService;
//import com.eliseeva.shop.purchase.PurchaseService;
//import com.eliseeva.shop.rest.dto.*;
//import com.eliseeva.shop.users.UserEntity;
//import com.eliseeva.shop.users.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//@RequestMapping(value = "/admin")
//public class AdminController {
//    private final CakesService cakesService;
//    private final PurchaseService purchaseService;
//    private final UserService userService;
//    private final OrderService orderService;
//
//
//
//    @Autowired
//    public AdminController(CakesService cakesService, PurchaseService purchaseService, OrderService orderService, UserService userService) {
//        this.cakesService = cakesService;
//        this.purchaseService = purchaseService;
//        this.orderService = orderService;
//        this.userService = userService;
//    }
//
//    @GetMapping(value = "/cakes")
//    public String getListOfCakes(Model model) {
//        model.addAttribute("cakes",cakesService.getCakes().getCakeList());
//        model.addAttribute("cake", new InfoAboutCake());
//        return "cakes";
//    }
//
//    @GetMapping(value = "cake/{id}")
//    public String getCakeById(@PathVariable Long id, Model model) {
//        model.addAttribute("cake",cakesService.getInfoAboutCake(id));
//        return "cake";
//    }
//
//    @PostMapping("/addCake")
//    public String addCake(@ModelAttribute InfoAboutCake cake) {
//        cakesService.addCake(cake);
//
//        return "redirect:/admin/cakes";
//    }
//
//    @GetMapping(value = "orders")
//    public String getListOfOrders(Model model) {
//        model.addAttribute("orders",orderService.getOrders().getOrderList());
//        model.addAttribute("order", new InfoAboutOrder());
//        return "orders";
//    }
//    @PostMapping("/addNewOrder")
//    public String addOrder(@ModelAttribute InfoAboutOrder mOrder) {
//        UserEntity user = userService.addUser(mOrder.getUser());
//        OrderEntity order = orderService.addNewOrder(mOrder.getOrder(), user);
//        for (Purchase purchase : mOrder.getPurchases())
//            purchaseService.addPurchase(order, cakesService.getCakeEntity(purchase.getCakeId()), purchase.getNumber());
//        return "redirect:/admin/orders";
//    }
//
//    @GetMapping(value = "editCake/{id}")
//    public String getEditCakePage(InfoAboutCake cake,Model model) {
//        model.addAttribute("cake", cake);
//        return "editCake";
//    }
//    @PostMapping(path = "editCake")
//    public String editCake(@ModelAttribute InfoAboutCake cake) {
//        cakesService.editCake(cake);
//        return "redirect:/admin/cakes";
//    }
//
//    @GetMapping(value = "editOrder/{id}")
//    public String getEditOrder(Order order,Model model) {
//        model.addAttribute("order", order);
//        return "editOrder";
//    }
//    @PostMapping(path = "editOrder")
//    public String editOrder(@ModelAttribute Order order) {
//        orderService.editOrder(order);
//        return "redirect:/admin/orders";
//    }
//
//    @GetMapping(value = "deleteCake/{id}")
//    public String deleteCakeById (@PathVariable Long id) {
//        cakesService.deleteCakeById(id);
//        return "redirect:/admin/cakes";
//    }
//
//    @GetMapping(value = "deleteOrder/{id}")
//    public String deleteOrderById (@PathVariable Long id) {
//        orderService.deleteOrderById(id);
//        return "redirect:/admin/orders";
//    }
//}
