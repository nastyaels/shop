package com.eliseeva.shop.goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<CakeEntity,Long>, CustomCakeRepository{

    boolean existsByName(String name);


}
