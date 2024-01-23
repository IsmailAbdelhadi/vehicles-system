package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaneController implements VehicleController{

    private DatabaseOperations databaseOperations;

    @Autowired
    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }

    @Override
    public void getVehicleById(Vehicle vehicle) {
        databaseOperations.getVehicleById(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        databaseOperations.update(vehicle);
    }
}
