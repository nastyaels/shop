package com.eliseeva.shop.goods;

import com.eliseeva.shop.rest.dto.Cake;
import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.rest.dto.InfoAboutCake;


public interface CakesService {
    Cakes getCakes();
    Cake getCakeById(Long id);
    void addCake(InfoAboutCake cake);
    void deleteCakeById(Long id);
    void editCake(Long id,InfoAboutCake cake);
}
