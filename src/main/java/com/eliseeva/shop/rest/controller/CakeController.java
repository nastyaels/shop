package com.eliseeva.shop.rest.controller;

import com.eliseeva.shop.goods.CakesServiceImpl;
import com.eliseeva.shop.rest.dto.Cake;
import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.exceptions.CakeNotFoundException;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
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
    private static long idCounter = 0;
    private final CakesServiceImpl cakesService;
    private final Cakes cakeList = new Cakes();

//    public CakeController(){
//        Cake cake1 = new Cake();
//        idCounter++;
//        cake1.setId(1L);
//        cake1.setName("medovik");
//        cake1.setPrice(new BigDecimal(1000));
//        cake1.setCalories(new BigDecimal(1800));
//        cake1.setWeight(new BigDecimal(500));
//        cake1.setImage("cake1.jpg");
//
//        Cake cake2 = new Cake();
//        idCounter++;
//        cake2.setId(idCounter);
//        cake2.setName("Rose");
//        cake2.setPrice(new BigDecimal(200));
//        cake2.setWeight(new BigDecimal(200));
//        cake2.setImage("cake1.jpg");
//        cake2.setCalories(new BigDecimal(200));
//
//        List<Cake> tmp = new ArrayList<Cake>();
//        tmp.add(cake1);
//        tmp.add(cake2);
//        cakeList.setCakeList(tmp);
//    }


    @Autowired
    public CakeController(CakesServiceImpl cakesService) {
        List<Cake> tmp = new ArrayList<Cake>();
        cakeList.setCakeList(tmp);
        this.cakesService = cakesService;
    }

    @GetMapping(value = "cakes",produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes getListOfCakes(){
        return cakesService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public InfoAboutCake getCakeById(@PathVariable Long id) {
        return cakesService.getInfoAboutCake(id);
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> addCake(@RequestBody @Valid Cake mcake){
        if(mcake.getId() == null || mcake.getCalories() == null ||
                mcake.getImage() == null || mcake.getName() == null || mcake.getWeight() == null || mcake.getPrice() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            cakeList.getCakeList().add(mcake);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
