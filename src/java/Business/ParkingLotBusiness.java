/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ParkingLotData;
import Domain.ParkingLot;
import Domain.Space;
import Domain.User;
import Domain.UserOperations;
import Domain.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Arturo
 */
public class ParkingLotBusiness {

    ParkingLotData parkingLotData;

    public ParkingLotBusiness() {

        parkingLotData = new ParkingLotData();
    }

//    public ParkingLot registerParkingLot(String nameOfParkingLot, Space spaces[]) {
//
////        return parkingLotData.registerParkingLot(nameOfParkingLot, spaces);
//    }

    public void registerParkingLot(ParkingLot parkingLot) throws IOException{
        
//        parkingLotData.registerParkingLotInFile(parkingLot);
//        parkingLotData.registerParkingLot(parkingLot);
    }
    
    public int registerVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot) throws ParseException, IOException{
//        System.out.println("estoy en Business" );
        System.out.println("INFO VEHICLE "+vehicle.toString());
        int i = parkingLotData.registerVehicleInParkingLot(vehicle, parkingLot);;
        return i;
    }
    
//    public void removeVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot){
//        
//        parkingLotData.removeVehicleFromParkingLot(vehicle, parkingLot);
//    }
//    
//    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException{
////        parkingLotData.getAllParkingLotsFromFile();
//        return parkingLotData.getAllParkingLots();
//    }
//    
//    public ParkingLot findParkingLotById(int parkingLotId){
//        
////        return parkingLotData.findParkingLotById(parkingLotId);
//    }

 
    public ParkingLot getParkingLotByName(String parkingLotName) throws ParseException {
        return parkingLotData.getParkingLotByName(parkingLotName);
    }

}
