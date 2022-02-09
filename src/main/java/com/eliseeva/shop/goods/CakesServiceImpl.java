package com.eliseeva.shop.goods;
import com.eliseeva.shop.rest.dto.Cake;
import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CakesServiceImpl implements CakesService{
//    private final CakeRepository cakeRepository;

    private final CakeDAO cakeDAO;
    @Autowired
    public CakesServiceImpl (CakeDAO cakeDAO){
        this.cakeDAO = cakeDAO;
    }
//    public CakesServiceImpl(CakeRepository cakeRepository) {
//        this.cakeRepository = cakeRepository;
//    }

    @Override
    public Cakes getCakes(){
        List<CakeEntity> cakeEntityList = cakeDAO.getListOfCakes();
        List<Cake> cakeList =  cakeEntityList.stream().map(c -> {
            Cake cake = new Cake();
            cake.setId(c.getId());
            cake.setName(c.getName());
            cake.setImage(c.getImage());
            cake.setCalories(c.getCalories());
            cake.setPrice(c.getPrice());
            cake.setWeight(c.getWeight());
            return cake;
        }).collect(Collectors.toList());
        Cakes cakes = new Cakes();
        cakes.setCakeList(cakeList);
        return cakes;
    }

    @Override
    public Cake getCakeById(Long id) {
        var mcake = cakeDAO.getCakeById(id);
        var cake = new Cake();
        cake.setId(mcake.getId());
        cake.setWeight(mcake.getWeight());
        cake.setName(mcake.getName());
        cake.setPrice(mcake.getPrice());
        cake.setCalories(mcake.getCalories());
        cake.setImage(mcake.getImage());
        return cake;
    }
//    @Override
//    public InfoAboutCake getInfoAboutCake(Long id){
//        return cakeDAO.getCakeById(id).map(c ->{
//            InfoAboutCake infoAboutCake = new InfoAboutCake();
//            infoAboutCake.setId(c.getId());
//            infoAboutCake.setCalories(c.getCalories());
//            infoAboutCake.setImage(c.getImage());
//            infoAboutCake.setName(c.getName());
//            infoAboutCake.setPrice(c.getPrice());
//            infoAboutCake.setWeight(c.getWeight());
//            infoAboutCake.setIngredients(c.getIngredients());
//            return infoAboutCake;
//        }).orElseThrow(()-> new CakeNotFoundException("no info about this cake"));
//    }
//    @Override
//    public CakeEntity getCakeEntity(Long id){
//        return cakeRepository.findById(id).get();
//    }

    @Override
    public void addCake(InfoAboutCake cake){
        cakeDAO.addCake(cake);
    }

    @Override
    public void deleteCakeById(Long id){
        cakeDAO.deleteCakeById(id);
    }

    @Override
    public void editCake(Long id, InfoAboutCake cake){
        cakeDAO.editCake(id,cake);
    }
}
