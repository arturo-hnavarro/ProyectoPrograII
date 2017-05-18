/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.ParkingLotData;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arturo
 */
public class ParkingLotDataTest {

    ParkingLotData parkingLotData;

    public ParkingLotDataTest() throws IOException {
        parkingLotData = new ParkingLotData();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void insertParkingLot() throws IOException{
//        //ParkingLot 1
//        ArrayList<Vehicle> vehicles = new ArrayList<>();
//        Space[] spaces = new Space[3];
//
//        spaces[0] = new Space(1, true, false, new VehicleType(1, "Bicicleta", (byte)2, 200));
//        spaces[1] = new Space(2, false, false, new VehicleType(3, "Camión", (byte)4, 1500));
//        spaces[2] = new Space(2, true, false, new VehicleType(2, "liviano", (byte)4, 700));
//        ParkingLot p1 = new ParkingLot("Parque del Norte", 3, vehicles, spaces);
//        parkingLotData.registerParkingLotInFile(p1);
//        
//        //ParkingLot 2
//        ArrayList<Vehicle> vehicles2 = new ArrayList<>();
//        Space[] spaces2 = new Space[2];
//
//        spaces2[0] = new Space(1, true, false, new VehicleType(1, "liviano", (byte)2, 800));
//        spaces2[1] = new Space(2, true, false, new VehicleType(5, "Caballo", (byte)4, 2000));
//        
//        ParkingLot p2 = new ParkingLot("Parqueo del este", 2, vehicles2, spaces2);
//        parkingLotData.registerParkingLotInFile(p2);
//        
//    }
    
    @Test
    public void modifyParkingLot() throws ParseException, IOException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Space[] spaces = new Space[3];
        spaces[0] = new Space(1, true, false, new VehicleType(1, "LIVIANO", (byte) 4, 700));
        spaces[1] = new Space(2, false, false, new VehicleType(3, "Camión", (byte) 4, 5000));
        spaces[2] = new Space(2, false, false, new VehicleType(2, "MOTO", (byte) 4, 400));
        ParkingLot p = new ParkingLot(2, "NOMBRE CAMBIADO", 3, vehicles, spaces);

        parkingLotData.modifyParkingLot(p);
    }
     @Test
     public void getAllParkingLotFromFile() throws ParseException {
         System.out.println("*** Nombre de la PRUEBA ***\ngetAllParkingLotFromFile()");
         LinkedList<ParkingLot> parkingLots = parkingLotData.getAllParkingLotsFromFile();
         for (int i = 0; i < parkingLots.size(); i++) {
             System.out.println(parkingLots.get(i).toString());
         }
     }

}
