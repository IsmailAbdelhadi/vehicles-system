DROP DATABASE IF EXISTS vehicle_system;

CREATE DATABASE vehicle_system;

USE vehicle_system;

CREATE TABLE Vehicle (
    ID INT AUTO_INCREMENT,
    brand VARCHAR(255),
    type VARCHAR(255),
    PRIMARY KEY (ID)
);


CREATE TABLE orders (
    id INT AUTO_INCREMENT,
    Order_Date DATE,
    Price DECIMAL(10, 2),
    Vehicle_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (Vehicle_id) REFERENCES Vehicle(ID)
);