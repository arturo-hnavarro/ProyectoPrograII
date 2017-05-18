/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Customer;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Arturo
 */
public class ParkingLotData {

    static LinkedList<ParkingLot> parkingLots;
    static int parkingLotId = 1;
    final String jsonFilePath = "files//parkingLots.json";
 
    

    public ParkingLotData()  {
 
    }

    

    public void registerParkingLot(ParkingLot parkingLot) throws IOException {

        parkingLots.add(parkingLot);
    }

    public void removeVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot) {

        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        Space spaces[] = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //debemos retirar al vehículo actual
        for (int i = 0; i < vehiclesInParkingLot.size(); i++) {

            if (vehiclesInParkingLot.get(i) == vehicle) {

                vehiclesInParkingLot.remove(vehicle);
                spaces[i].setSpaceTaken(false);
                break;
            }

        }
        parkingLot.setSpaces(spaces);
        parkingLot.setVehicles(vehiclesInParkingLot);

    }

    public LinkedList<ParkingLot> getAllParkingLots() {

        return parkingLots;
    }



    //CRUD
    public void registerParkingLotInFile(ParkingLot parkingLot) throws IOException {
        JSONObject parkingLotObject = new JSONObject();
        parkingLotObject.put("parkingLotId", parkingLot.getId());
        parkingLotObject.put("name", parkingLot.getName());
        parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

        JSONArray vehicleList = new JSONArray();
        parkingLotObject.put("vehicleList", vehicleList);

        //Add the information of spaces
        ArrayList<JSONObject> jsonArraySpaces = new ArrayList<>();

        for (int i = 0; i < parkingLot.getSpaces().length; i++) {
            JSONObject spacesObject = new JSONObject();
            spacesObject.put("idSpace", parkingLot.getSpaces()[i].getId());
            spacesObject.put("disabilityAdaptation", parkingLot.getSpaces()[i].isDisabilityAdaptation());
            spacesObject.put("spaceTaken", false);

            //Add the information of VehicleType related to the space
            JSONObject vehicleTypeObject = new JSONObject();
            vehicleTypeObject.put("id", parkingLot.getSpaces()[i].getVehicleType().getId());
            vehicleTypeObject.put("description", parkingLot.getSpaces()[i].getVehicleType().getDescription());
            vehicleTypeObject.put("numberOfTires", parkingLot.getSpaces()[i].getVehicleType().getNumberOfTires());
            vehicleTypeObject.put("fee", parkingLot.getSpaces()[i].getVehicleType().getNumberOfTires());

            spacesObject.put("VehicleType", vehicleTypeObject);//Add the VehicleType to the SpaceObject
            jsonArraySpaces.add(spacesObject);//Add the space to the ParkingLot
            parkingLotObject.put("spaces", jsonArraySpaces);
        }
        //true allows multiple insertions in the file
            try (FileWriter file = new FileWriter(jsonFilePath, true)) {
                file.write(parkingLotObject.toJSONString() + "\r\n");
                file.close();
            }
            

    }

    public LinkedList<ParkingLot> getAllParkingLotsFromFile() throws ParseException {
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        JSONObject jsonObject;
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                jsonObject = (JSONObject) new JSONParser().parse(line);

                ParkingLot parkingLot = new ParkingLot();
                parkingLot.setName(jsonObject.get("name").toString());
                parkingLot.setId(Integer.parseInt(jsonObject.get("parkingLotId").toString()));
                parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));

                JSONArray spacesList = (JSONArray) jsonObject.get("spaces");
                Space[] spaces = new Space[parkingLot.getNumberOfSpaces()];
                parkingLot.setSpaces(getSpaces(spacesList, spaces));

                JSONArray vehicleList = (JSONArray) jsonObject.get("vehicleList");
                parkingLot.setVehicles(getVehiclesFromParkingLot(vehicleList));
                parkingLots.add(parkingLot);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return parkingLots;
    }

    public void modifyParkingLot(ParkingLot parkingLotToModify) throws ParseException, IOException {
        //En capa de business controlar que no cambie el id del parqueo y que, no existan vehiculos estacionados
        LinkedList<ParkingLot> parkingLots = getAllParkingLotsFromFile();

        boolean found = false;
        int startPosition = 0;
        int finalPosition = parkingLots.size() - 1;

        while (startPosition <= finalPosition && !found) { //Searching the parkingLot to modify
            int middle = (startPosition + finalPosition) / 2;
            if (parkingLots.get(middle).getId() == parkingLotToModify.getId()) {
                parkingLots.get(middle).setName(parkingLotToModify.getName());
                parkingLots.get(middle).setNumberOfSpaces(parkingLotToModify.getNumberOfSpaces());
                parkingLots.get(middle).setSpaces(parkingLotToModify.getSpaces());
                found = true;
            } else if (parkingLots.get(middle).getId() < parkingLotToModify.getId()) {
                startPosition = middle + 1;
            } else if (parkingLots.get(middle).getId() > parkingLotToModify.getId()) {
                finalPosition = middle - 1;
            }
        }//while
        
        //Update the file
        //false: not allowed multiple insertions in the file
        FileWriter file = new FileWriter(jsonFilePath, false);
        for (ParkingLot parkingLot : parkingLots) {
            registerParkingLotInFile(parkingLot);
        }
        
        
        
        

    }

//utility methods
    private Space[] getSpaces(JSONArray spacesList, Space[] spaces) throws ParseException {
        if (!spacesList.isEmpty()) {
            int index = 0;
            Iterator<JSONObject> iterator = spacesList.iterator();
            while (iterator.hasNext()) {
                JSONObject currentJsonSpace = (JSONObject) new JSONParser().parse(iterator.next().toJSONString());
                int id = Integer.parseInt(currentJsonSpace.get("idSpace").toString());
                boolean disabilityAdaptation = (currentJsonSpace.get("disabilityAdaptation").toString().equals("true")) ? true : false;
                boolean spaceTaken = (currentJsonSpace.get("spaceTaken").toString().equals("true")) ? true : false;
                VehicleType vehicleType = new VehicleType();

                JSONObject vehicleTypeObject = (JSONObject) currentJsonSpace.get("VehicleType");
                vehicleType.setId(Integer.parseInt(vehicleTypeObject.get("id").toString()));
                vehicleType.setDescription(vehicleTypeObject.get("description").toString());
                vehicleType.setNumberOfTires(Byte.parseByte(vehicleTypeObject.get("numberOfTires").toString()));
                vehicleType.setFee(Float.parseFloat(vehicleTypeObject.get("fee").toString()));
                spaces[index++] = new Space(id, disabilityAdaptation, spaceTaken, vehicleType);
            }//while
        }//if 
        return spaces;
    }

    private ArrayList<Vehicle> getVehiclesFromParkingLot(JSONArray vehicleList) throws ParseException {
        ArrayList<Vehicle> vehiclesToshow = new ArrayList<>();

        if (!vehicleList.isEmpty()) {
            Iterator<String> iterator = vehicleList.iterator();
            while (iterator.hasNext()) {
                String currentObjet = iterator.next();
                JSONObject currentJsonVehicle = (JSONObject) new JSONParser().parse(currentObjet);//Change the string to JSONObject
                String plate = currentJsonVehicle.get("plate").toString();
                String color = currentJsonVehicle.get("color").toString();
                String brand = currentJsonVehicle.get("brand").toString();
                String model = currentJsonVehicle.get("model").toString();
                VehicleType vehicleType = new VehicleType();
                JSONObject currentVehicleType = (JSONObject) new JSONParser().parse(currentJsonVehicle.get("VehicleType").toString());//Change the string to JSONObject
                vehicleType.setId(Integer.parseInt(currentVehicleType.get("id").toString()));
                vehicleType.setDescription(currentVehicleType.get("description").toString());
                vehicleType.setNumberOfTires(Byte.parseByte(currentVehicleType.get("numberOfTires").toString()));
                vehicleType.setFee(Float.parseFloat(currentVehicleType.get("fee").toString()));
                Vehicle currentVehicle = new Vehicle(plate, color, brand, model, new Customer(), vehicleType);
                vehiclesToshow.add(currentVehicle);
            }
        }
        return vehiclesToshow;
    }

}
