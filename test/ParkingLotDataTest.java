/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.ParkingLotData;
import Domain.ParkingLot;
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
    
    public ParkingLotDataTest() {
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

    // TODO add test methods here.
     @Test
     public void getAllParkingLotFromFile() throws ParseException {
         System.out.println("*** Nombre de la PRUEBA ***\ngetAllParkingLotFromFile()");
         LinkedList<ParkingLot> parkingLots = parkingLotData.getAllParkingLotsFromFile();
         for (int i = 0; i < parkingLots.size(); i++) {
             System.out.println(parkingLots.get(i).toString());
         }
     }
}
