/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Arturo
 */
public class Vehicle {

    private String plate;
    private String color;
    private String brand;
    private String model;
    private String comments;//Observations about the Vehicle
    private int idParkingLot;
    private ArrayList<Customer> customers;
    private VehicleType vehicleType;

    public Vehicle() {
        customers = new ArrayList<>();
    }

    public Vehicle(String plate, String color, String brand,String comments, String model, VehicleType vehicleType) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.comments = comments;
        this.vehicleType = vehicleType;
        this.customers = new ArrayList<>();
    }

    public Vehicle(String plate, String color, String brand, String model, String comments, int idParkingLot, VehicleType vehicleType, Customer customer) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.comments = comments;
        this.idParkingLot = idParkingLot;
        this.vehicleType = vehicleType;
        this.customers = new ArrayList<>();
        this.customers.add(customer);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public VehicleType getVehiculeType() {
        return vehicleType;
    }

    public void setVehiculeType(VehicleType vehiculeType) {
        this.vehicleType = vehiculeType;
    }

    public int getIdParkingLot() {
        return idParkingLot;
    }

    public void setIdParkingLot(int idParkingLot) {
        this.idParkingLot = idParkingLot;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "plate=" + plate + ", color=" + color + ", brand=" + brand + ", model=" + model + ", comments=" + comments + ", idParkingLot=" + idParkingLot + ", customers=" + customers + ", vehicleType=" + vehicleType + '}';
    }
}
