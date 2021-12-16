package com.eliseeva.shop.goods;

import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.rest.dto.InfoAboutCake;


public interface CakesService {
    Cakes getCakes();
    InfoAboutCake getInfoAboutCake(Long id);
    CakeEntity getCakeEntity(Long id);
    CakeEntity addCake(InfoAboutCake cake);
    void deleteCakeById(Long id);
    void editCake(InfoAboutCake cake);
}
