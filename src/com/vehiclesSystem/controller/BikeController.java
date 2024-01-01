package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BikeController implements VehicleController {

    @Autowired
    private DatabaseOperations databaseOperations;


    @Override
    public void saveVehicle(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }

    @Override
    public void getVehicleById(Vehicle vehicle) {
        databaseOperations.getVehicleById(vehicle);
    }
}
