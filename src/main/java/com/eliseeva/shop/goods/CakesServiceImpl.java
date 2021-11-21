package com.eliseeva.shop.goods;

import com.eliseeva.shop.exceptions.CakeNotFoundException;
import com.eliseeva.shop.rest.dto.Cake;
import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CakesServiceImpl implements CakesService{
    private final CakeRepository cakeRepository;

    @Autowired
    public CakesServiceImpl(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @Override
    public Cakes getCakes(){
        List<CakeEntity> cakeEntityList = cakeRepository.findAll();
        List<Cake> cakeList =  cakeEntityList.stream().map(c -> {
            Cake cake = new Cake();
            cake.setId(c.getId());
            cake.setCalories(c.getCalories());
            cake.setName(c.getName());
            cake.setPrice(c.getPrice());
            cake.setImage(c.getImage());
            cake.setWeight(c.getWeight());
            return cake;
        }).collect(Collectors.toList());
        Cakes cakes = new Cakes();
        cakes.setCakeList(cakeList);
        return cakes;
    }
    @Override
    public InfoAboutCake getInfoAboutCake(Long id){
        return cakeRepository.findById(id).map(c ->{
            InfoAboutCake infoAboutCake = new InfoAboutCake();
            infoAboutCake.setId(c.getId());
            infoAboutCake.setCalories(c.getCalories());
            infoAboutCake.setImage(c.getImage());
            infoAboutCake.setName(c.getName());
            infoAboutCake.setPrice(c.getPrice());
            infoAboutCake.setWeight(c.getWeight());
            infoAboutCake.setIngredients(c.getIngredients());
            return infoAboutCake;
        }).orElseThrow(()-> new CakeNotFoundException("no info about this cake"));
    }
    @Override
    public CakeEntity getCakeEntity(Long id){
        return cakeRepository.findById(id).get();
    }

    @Override
    public void addCake(InfoAboutCake cake){
        CakeEntity cakeEntity = new CakeEntity();
    }
}
