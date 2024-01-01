package com.vehiclesSystem;

import com.vehiclesSystem.config.ConfigClass;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.model.Car;
import com.vehiclesSystem.model.Type;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

        System.out.println("---------car bean -------------");
        Car car = context.getBean("car", com.vehiclesSystem.model.Car.class);
        car.setBrand("AUDI");
        car.setType(Type.car);
        car.setId("13");
        CarController carController = context.getBean("carController", com.vehiclesSystem.controller.CarController.class);
        //carController.saveVehicle(car);
        //carController.updateVehicle(car);
        //carController.deleteVehicle(car);
        carController.getVehicleById(car);
        //carController.getOrdersDetails();



        context.close();
    }
}