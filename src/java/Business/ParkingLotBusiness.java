/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ParkingLotData;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Arturo
 */
public class ParkingLotBusiness {

    ParkingLotData parkingLotData;
    final String jsonFilePath = "files//parkingLots.json";
    final String jsonFileTempPath = "files//parkingLotsTemp.json";

    public ParkingLotBusiness() throws IOException {

        parkingLotData = new ParkingLotData();
    }

    public void registerParkingLot(ParkingLot parkingLot) throws IOException, ParseException{
        
        parkingLotData.registerParkingLot(parkingLot);
    }
    public void modifyParkingLot(ParkingLot parkingLot) throws IOException, ParseException{
        
        parkingLotData.modifyParkingLot(parkingLot);
    }
    
//    public int registerVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot){
//        
//        return parkingLotData.registerVehicleInParkingLot(vehicle, parkingLot);
//    }
    
    public void removeVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot){
        
        parkingLotData.removeVehicleFromParkingLot(vehicle, parkingLot);
    }
    
    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException{
        
        return parkingLotData.getAllParkingLots();
    }
    
   

}
