package com.eliseeva.shop.goods;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CakeDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCake(InfoAboutCake cake){
        try {
            var statement = connection.createStatement();
            var SQL = "INSERT INTO cake (calories, image, ingredients, name, price, weight) VALUES(" + cake.getCalories()+",'"+
                    cake.getImage() + "','" + cake.getIngredients() + "','" + cake.getName() + "'," +
                    cake.getPrice() + "," + cake.getWeight() + ")";
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CakeEntity getCakeById(Long id){
        var cake = new CakeEntity();
        try {
            var statement = connection.createStatement();
            var SQL = "SELECT * FROM cake WHERE id="+id;
            var resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                cake.setId(resultSet.getLong("id"));
                cake.setName(resultSet.getString("name"));
                cake.setCalories(resultSet.getBigDecimal("calories"));
                cake.setImage(resultSet.getString("image"));
                cake.setPrice(resultSet.getBigDecimal("price"));
                cake.setWeight(resultSet.getBigDecimal("weight"));
                cake.setIngredients(resultSet.getString("ingredients"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cake;
    }

    public List<CakeEntity> getListOfCakes(){
        var cakes = new ArrayList<CakeEntity>();
        try {
            var statement = connection.createStatement();
            var SQL = "SELECT * FROM cake";
            var resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                var cake = new CakeEntity();
                cake.setId(resultSet.getLong("id"));
                cake.setName(resultSet.getString("name"));
                cake.setCalories(resultSet.getBigDecimal("calories"));
                cake.setImage(resultSet.getString("image"));
                cake.setPrice(resultSet.getBigDecimal("price"));
                cake.setWeight(resultSet.getBigDecimal("weight"));

                cakes.add(cake);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cakes;
    }

    public void editCake(Long id, InfoAboutCake infoAboutCake){
        try {
            var statement = connection.createStatement();
            var SQL = "UPDATE cake SET calories="+infoAboutCake.getCalories()+
                    ",image='"+infoAboutCake.getImage()+"',ingredients='"+infoAboutCake.getIngredients()+"',name='"+
                    infoAboutCake.getName()+"',price="+infoAboutCake.getPrice()+",weight="+infoAboutCake.getWeight()+
                    " WHERE id="+id;
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCakeById(Long id){
        try {
            var statement = connection.createStatement();
            var SQL = "DELETE FROM cake WHERE id="+id;
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
