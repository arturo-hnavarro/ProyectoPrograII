/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.CustomerBusiness;
import Business.ParkingLotBusiness;
import Domain.Customer;
import Domain.ParkingLot;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Arturo
 */
@WebServlet(name = "VehicleInfoServlet", urlPatterns = {"/VehicleInfoServlet"})
public class VehicleInfoServlet extends HttpServlet {

    ParkingLotBusiness parkingLotBusiness;
    String plate;
    String color;
    String brand;
    String comments;
    String model;
    String vehicleTypeId;
    String parkingLotName;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        parkingLotBusiness = new ParkingLotBusiness();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        plate = request.getParameter("plate");
        color = request.getParameter("color");
        brand = request.getParameter("brand");
        comments = request.getParameter("comments");
        model = request.getParameter("model");
        vehicleTypeId = request.getParameter("vehicleTypeId");//TODO: metodo para obtener vehicleTypeById
        parkingLotName = request.getParameter("parkingLotName");//TODO: metodo para obtener parkingLotByName
        VehicleType vehicleType = new VehicleType();

        RequestDispatcher dispacher = request.getRequestDispatcher("register_customer_to_vehicle.jsp");
        dispacher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //Create a new Vehicle
        VehicleType vehicleType = new VehicleType(3, "Camión", (byte) 4, (float) 4);

        //Create the Customer
        String identification = request.getParameter("id");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "Customer";
        Boolean disabilityPresented = (request.getParameter("disabilityPresented").equals("yes"));

        Customer customer = new Customer(disabilityPresented, identification, name, username, password, role);
        Vehicle vehicle = new Vehicle(plate, color, brand, model, comments, 1, vehicleType, customer);
        ParkingLot parkingLot = null;
        int spaceGiven = 0;

        try {
            parkingLot = parkingLotBusiness.getParkingLotByName("Parque del Norte");
            spaceGiven = parkingLotBusiness.registerVehicleInParkingLot(vehicle, parkingLot);

        } catch (ParseException ex) {
            Logger.getLogger(VehicleInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Show the information of the complete process
        response.setHeader("spaceGiven", ""+spaceGiven);
        response.setHeader("parkingLotName", ""+parkingLotName);
         //Vehicle info
        response.setHeader("plate", ""+plate);
        response.setHeader("color", ""+color);
        response.setHeader("brand", ""+brand);
        response.setHeader("model", ""+model);
        response.setHeader("comments", ""+comments);
        response.setHeader("vehicleTypeId", ""+vehicleTypeId);
        
 
        //Customer info
        response.setHeader("identification", identification);
        response.setHeader("name", name);
        response.setHeader("username", username);
        response.setHeader("password", password);
        response.setHeader("disabilityPresented", disabilityPresented==true?"Sí":"No");
        
        

        RequestDispatcher dispacher1 = request.getRequestDispatcher("show_vehicle_registered_in_parkingLot.jsp");
        dispacher1.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Gets the data from de vehicle and post it to the insert customer to register the vehicle in a parkingLot";
    }// </editor-fold>

}
