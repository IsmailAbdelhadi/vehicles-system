package com.vehiclesSystem.controller;

import com.vehiclesSystem.model.Vehicle;

public interface VehicleController {

    public void saveVehicle(Vehicle vehicle);
    public void getVehicleById(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
//    public void deleteVehicle(Vehicle vehicle);
//
//    public ArrayList<Orders> getOrdersDetails();
}
