package com.vehiclesSystem.dao;


import com.vehiclesSystem.model.Type;
import com.vehiclesSystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;


//this is a DAO class

@Component
@Scope("singleton")
public class DatabaseOperations {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    private Connection connection;
    private PreparedStatement preparedStatement;

    @PostConstruct
    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private  void disconnectToDatabase()  {
        try {
            connection.close();
            System.out.println("connection closed....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Vehicle save(Vehicle vehicle) {
        try {
            String INSERT_QUERY = "INSERT INTO vehicle (brand,type) "+"VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, vehicle.getBrand());
            preparedStatement.setString(2, vehicle.getType().toString());

            int rowAffected = preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(vehicle.getType()+" has been saved successfully !!");
        return vehicle;
    }


    public void getVehicleById(Vehicle vehicle){
        try {
            String SELECT_QUERY = "SELECT * FROM vehicle WHERE id ='"+vehicle.getId()+"'";
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
            ResultSet result = preparedStatement.executeQuery(SELECT_QUERY);
            while(result.next()){
                String id = result.getString("id");
                String brand = result.getString("brand");
                Type type = Type.valueOf(result.getString("type"));
                vehicle.setId(id);
                vehicle.setBrand(brand);
                vehicle.setType(type);
                System.out.println("ID: "+id+" brand: "+brand+" type: "+type);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public int update(Vehicle vehicle){
        int affectedRows = 0;
        try{
            String UPDATE_QUERY = "UPDATE vehicle SET brand = ? WHERE id ='"+vehicle.getId()+"'";

            preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1,vehicle.getBrand());
            affectedRows = preparedStatement.executeUpdate();
            System.out.println("affectedRows "+affectedRows);

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(vehicle.getType()+" has been updated successfully !!");
        return affectedRows;
    }




}
