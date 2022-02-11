package com.eliseeva.shop.goods;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
import com.eliseeva.shop.rest.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CakeDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CakeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCake(InfoAboutCake cake){
        jdbcTemplate.update("INSERT INTO cake (calories, image, ingredients, name, price, weight) " +
                "VALUES (?,?,?,?,?,?)",cake.getCalories(),cake.getImage(),cake.getIngredients(),cake.getName(),
                cake.getPrice(),cake.getWeight());
    }

    public CakeEntity getCakeById(Long id){
        return jdbcTemplate.query("SELECT * FROM cake WHERE id=?", new MapperCake(), id)
                .stream().findAny().orElse(null);
    }

    public List<CakeEntity> getListOfCakes(){
       return jdbcTemplate.query("SELECT * FROM cake",new MapperCake());
    }

    public void editCake(Long id, InfoAboutCake infoAboutCake){
        jdbcTemplate.update("UPDATE cake SET calories=?, image=?,ingredients=?,name=?,price=?,weight=? WHERE id =?",
                infoAboutCake.getCalories(),infoAboutCake.getImage(),infoAboutCake.getIngredients(),
                infoAboutCake.getName(), infoAboutCake.getPrice(), infoAboutCake.getWeight(),id);
    }

    public void deleteCakeById(Long id){
        jdbcTemplate.update("DELETE FROM cake WHERE id = ?",id);
    }

    public void addOrder(Order order){
       jdbcTemplate.update("INSERT INTO aboutorder (user_id, delivery, status, payment, delivery_address) " +
                        "VALUES (?,?,?,?,?)", order.getUserId(), order.getDelivery().ordinal(), order.getOrderStatus().ordinal(),
                order.getPayment().ordinal(), order.getDeliveryAddress());
    }
}