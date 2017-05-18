/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class ParkingLot {

    private int id;
    private String name;
    private transient int numberOfSpaces;
    private static int numberOfParkingLot = 1;
    private ArrayList<Vehicle> vehicles;
    private Space[] spaces;

    public ParkingLot() {
    }

    public ParkingLot(int id, String name, int numberOfSpaces, ArrayList<Vehicle> vehicles, Space[] spaces) {
        this.id = id;
        this.name = name;
        this.numberOfSpaces = numberOfSpaces;
        this.vehicles = vehicles;
        this.spaces = spaces;
    }

 

    public ParkingLot(String name, int numberOfSpaces, ArrayList<Vehicle> vehicles, Space[] spaces) {
        this.id = numberOfParkingLot++;
        this.name = name;
        this.numberOfSpaces = numberOfSpaces;
        this.vehicles = vehicles;
        this.spaces = spaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public void setNumberOfSpaces(int numberOfSpaces) {
        this.numberOfSpaces = numberOfSpaces;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Space[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Space[] spaces) {
        this.spaces = spaces;
    }

    @Override
    public String toString() {
        String string = "ParkingLot{" + "id=" + id + ", name=" + name + ", numberOfSpaces=" + numberOfSpaces + ", vehicles=" + vehicles + ", SPACES=\n";
        for (int i = 0; i < spaces.length; i++) {
            string += spaces[i].toString() + "\n";  
        }
        return string += "}\n";
    }

}
