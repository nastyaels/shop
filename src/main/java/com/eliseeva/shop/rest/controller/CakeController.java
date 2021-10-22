package com.eliseeva.shop.rest.controller;

import com.eliseeva.shop.dto.Cake;
import com.eliseeva.shop.dto.Cakes;
import com.eliseeva.shop.exceptions.CakeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class CakeController {
    private static long idCounter = 0;
    public CakeController(){
        Cake cake1 = new Cake();
        idCounter++;
        cake1.setId(1L);
        cake1.setName("medovik");
        cake1.setPrice(new BigDecimal(1000));
        cake1.setCalories(new BigDecimal(1800));
        cake1.setWeight(new BigDecimal(500));
        cake1.setImage("cake1.jpg");

        Cake cake2 = new Cake();
        idCounter++;
        cake2.setId(idCounter);
        cake2.setName("Rose");
        cake2.setPrice(new BigDecimal(200));
        cake2.setWeight(new BigDecimal(200));
        cake2.setImage("cake1.jpg");
        cake2.setCalories(new BigDecimal(200));

        List<Cake> tmp = new ArrayList<Cake>();
        tmp.add(cake1);
        tmp.add(cake2);
        cakeList.setCakeList(tmp);
    }

    private final Cakes cakeList = new Cakes();
    @GetMapping(value = "cakes",produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes getListOfCakes(){
        return cakeList;
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cake getCakeById(@PathVariable Long id) {
        return cakeList.getCakeList().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CakeNotFoundException("No such cake"));
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> addCake(@RequestBody Cake mcake){
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
