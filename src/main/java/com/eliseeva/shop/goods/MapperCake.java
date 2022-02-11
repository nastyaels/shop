package com.eliseeva.shop.goods;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCake implements RowMapper<CakeEntity> {
    @Override
    public CakeEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var cake = new CakeEntity();
        cake.setId(resultSet.getLong("id"));
        cake.setCalories(resultSet.getBigDecimal("calories"));
        cake.setImage(resultSet.getString("image"));
        cake.setIngredients(resultSet.getString("ingredients"));
        cake.setName(resultSet.getString("name"));
        cake.setPrice(resultSet.getBigDecimal("price"));
        cake.setWeight(resultSet.getBigDecimal("weight"));
        return cake;
    }
}
