/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Customer;
import Domain.Vehicle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Equipo
 */
public class CustomerData {

    final String jsonFilePath;

    public CustomerData() {
        this.jsonFilePath = "C:\\Users\\Arturo\\Desktop\\Proyecto Final Programacion II\\PruebasProyectoPrograII\\files\\customer.json";
    }

    public void insertCustomer(Customer customer) throws IOException, org.json.simple.parser.ParseException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("identification", customer.getIdentification());
        customerObject.put("name", customer.getName());
        customerObject.put("username", customer.getUsername());
        customerObject.put("password", customer.getPassword());
        customerObject.put("disabilityPresented", customer.isDisabilityPresented());
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(customerObject.toJSONString() + "\r\n");
        }
    }

    public LinkedList<Customer> getAllCustomers() throws ParseException, org.json.simple.parser.ParseException {
        LinkedList<Customer> customers = new LinkedList<>();
        ArrayList<JSONObject> jsonArray = new ArrayList<>();
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
                jsonArray.add(jsonObject);
                Customer customer = new Customer();

                customer.setIdentification(jsonObject.get("identification").toString());
                customer.setName(jsonObject.get("name").toString());
                customer.setUsername(jsonObject.get("username").toString());
                customer.setPassword(jsonObject.get("password").toString());
                customer.setDisabilityPresented(Boolean.parseBoolean(jsonObject.get("disabilityPresented").toString()));
                System.out.println(customer.toString());
                customers.add(customer);
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
        return customers;
    }

    public ArrayList<Customer> getCustomersByVehicle(Vehicle vehicle) {
        //TODO!!!! Leer los registros desde el archivo y obtener el 
        ArrayList<Vehicle> vehicles = VehicleData.vehicles;
        ArrayList<Customer> customersToReturn = new ArrayList<>();
        int index = 0;
        boolean found = false;
        do{
            if (vehicles.get(index).getPlate().equalsIgnoreCase(vehicle.getPlate())    ) {
                customersToReturn = vehicles.get(index).getCustomers();
                found = true;
            }
            index++;
        }while (index < vehicles.size() && !found );
        
        return vehicle.getCustomers();
    }

}
