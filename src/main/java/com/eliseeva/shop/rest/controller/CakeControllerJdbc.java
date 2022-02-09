package com.eliseeva.shop.rest.controller;
import com.eliseeva.shop.goods.CakesService;
import com.eliseeva.shop.rest.dto.Cake;
import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/cakes_jdbc")
public class CakeControllerJdbc {
    private final CakesService cakesService;

    @Autowired
    public CakeControllerJdbc(CakesService cakesService) {
        this.cakesService = cakesService;
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
}
