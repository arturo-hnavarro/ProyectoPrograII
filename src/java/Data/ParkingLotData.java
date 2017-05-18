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

    private LinkedList<ParkingLot> parkingLots;
    static int parkingLotId = 1;
    final String jsonFilePath = "files//parkingLots.json";

    public ParkingLotData() {
        parkingLots = new LinkedList<>();
    }

    public void registerParkingLot(ParkingLot parkingLot) throws IOException, ParseException {
        parkingLots.add(parkingLot);
        updateFile();
    }

    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException {
        updateParkingLotsFromFile();
        return this.parkingLots;
    }

    public void removeParkingLot(ParkingLot parkingLot) throws ParseException, IOException {
        updateParkingLotsFromFile();//get all the parkingLots in the file to the private LinkedList parkingLots
        for (int i = 0; i < this.parkingLots.size(); i++) {
            if (parkingLots.get(i).getId() == parkingLot.getId()
                    && parkingLots.get(i).getName().equalsIgnoreCase(parkingLot.getName())) {
                this.parkingLots.remove(i);
            }
        }
        updateFile();
    }

    public void modifyParkingLot(ParkingLot parkingLot) throws ParseException, IOException {
        //En ParkingLotBussines, controlar que el ParkingLot no tenga Vehicles para poder modificar
        updateParkingLotsFromFile();//get all the parkingLots in the file to the private LinkedList parkingLots
        boolean found = false;
        int startPosition = 0;
        int finalPosition = parkingLots.size() - 1;
        while (startPosition <= finalPosition && !found) { //Searching the parkingLot to modify
            int middle = (startPosition + finalPosition) / 2;
            if (parkingLots.get(middle).getId() == parkingLot.getId()) {
                this.parkingLots.get(middle).setName(parkingLot.getName());
                this.parkingLots.get(middle).setNumberOfSpaces(parkingLot.getNumberOfSpaces());
                this.parkingLots.get(middle).setVehicles(parkingLot.getVehicles());
                this.parkingLots.get(middle).setSpaces(parkingLot.getSpaces());
                found = true;
            } else if (parkingLots.get(middle).getId() < parkingLot.getId()) {
                startPosition = middle + 1;
            } else if (parkingLots.get(middle).getId() > parkingLot.getId()) {
                finalPosition = middle - 1;
            }
        }//while
        updateFile();
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

    public int registerVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot) throws ParseException, IOException {
        updateParkingLotsFromFile();
        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        Space spaces[] = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //podemos ingresar al vehículo actual
        for (int i = 0; i < spaces.length; i++) {

            if (spaces[i].isSpaceTaken() == false) {
                //preguntamos si el cliente presenta una capacidad particular
                //y requiere de un espacio adaptado
                //TODO: verificar para todos los customers
                if (vehicle.getCustomers().get(0).isDisabilityPresented()) {

                    if (spaces[i].isDisabilityAdaptation()) {

                        //compara el tipo de vehículo del espacio y del vehículo que se va a 
                        //estacionar (tipos: moto, automóvil, bus, etc)
                        if (spaces[i].getVehicleType().getId() == vehicle.getVehiculeType().getId()) {
                            vehiclesInParkingLot.add(vehicle);
                            spaces[i].setSpaceTaken(true);
                            //este es el número del espacio que se va a retornar
                            spaceId = spaces[i].getId();
                            break;
                        }

                    }
                } else if (!spaces[i].isDisabilityAdaptation()) {
                    //compara el tipo de vehículo del espacio y del vehículo que se va a 
                    //estacionar (tipos: moto, automóvil, bus, etc)
                    if (spaces[i].getVehicleType().getId() == vehicle.getVehiculeType().getId()) {

                        vehiclesInParkingLot.add(vehicle);
                        spaces[i].setSpaceTaken(true);
                        //este es el número del espacio que se va a retornar
                        spaceId = spaces[i].getId();
                        break;
                    }
                }
            }

        }
        parkingLot.setSpaces(spaces);
        parkingLot.setVehicles(vehiclesInParkingLot);
        
        //update parkingLots
        for (int i= 0 ; i<parkingLots.size(); i++) {
            if (parkingLots.get(i).getId()==parkingLot.getId()) {
                parkingLots.get(i).setId(parkingLot.getId());
                parkingLots.get(i).setName(parkingLot.getName());
                parkingLots.get(i).setNumberOfSpaces(parkingLot.getNumberOfSpaces());
                parkingLots.get(i).setSpaces(parkingLot.getSpaces());
                parkingLots.get(i).setVehicles(parkingLot.getVehicles());
                
            }
        }
        updateFile();
        return spaceId;
    }

//CRUD
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

    private void updateFile() throws IOException {
        try (FileWriter file = new FileWriter(jsonFilePath, false)) {
            for (ParkingLot parkingLot : this.parkingLots) {
                JSONObject parkingLotObject = transformParkingLotToJSONObject(parkingLot);
                //Add the object to file
                //true allows multiple insertions in the file
                file.write(parkingLotObject.toJSONString() + "\r\n");
            }
        }
    }//updateFile()

    private JSONObject transformParkingLotToJSONObject(ParkingLot parkingLot) {
        JSONObject parkingLotObject = new JSONObject();
        parkingLotObject.put("parkingLotId", parkingLot.getId());
        parkingLotObject.put("name", parkingLot.getName());
        parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());
        JSONArray vehicleList = new JSONArray();
        for (int i = 0; i < parkingLot.getVehicles().size(); i++) {
            JSONObject vehicleObject = new JSONObject();
            vehicleObject.put("Brand", parkingLot.getVehicles().get(i).getBrand());
            vehicleObject.put("Color", parkingLot.getVehicles().get(i).getColor());
            vehicleObject.put("Plate", parkingLot.getVehicles().get(i).getPlate());
            vehicleList.add(vehicleObject);
        }
        parkingLotObject.put("vehicleList", vehicleList);
        parkingLotObject.put("spaces", getJsonSpaces(parkingLot.getSpaces()));

        return parkingLotObject;
    }

    private JSONArray getJsonSpaces(Space[] spaces) {
        JSONArray jsonArraySpaces = new JSONArray();
        for (int i = 0; i < spaces.length; i++) {
            JSONObject spacesObject = new JSONObject();
            spacesObject.put("idSpace", spaces[i].getId());
            spacesObject.put("disabilityAdaptation", spaces[i].isDisabilityAdaptation());
            spacesObject.put("spaceTaken", false);

            //Add the information of VehicleType related to the space
            JSONObject vehicleTypeObject = new JSONObject();
            vehicleTypeObject.put("id", spaces[i].getVehicleType().getId());
            vehicleTypeObject.put("description", spaces[i].getVehicleType().getDescription());
            vehicleTypeObject.put("numberOfTires", spaces[i].getVehicleType().getNumberOfTires());
            vehicleTypeObject.put("fee", spaces[i].getVehicleType().getNumberOfTires());

            spacesObject.put("VehicleType", vehicleTypeObject);//Add the VehicleType to the SpaceObject
            jsonArraySpaces.add(spacesObject);//Add the space to the ParkingLot
        }
        return jsonArraySpaces;
    }

    private void updateParkingLotsFromFile() throws ParseException {
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
                this.parkingLots.add(parkingLot);
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

    }

}
