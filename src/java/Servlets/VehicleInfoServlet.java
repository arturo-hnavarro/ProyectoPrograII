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
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
//            out.println("<title>Servlet VehicleInfoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet VehicleInfoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        plate = request.getParameter("plate");
        color = request.getParameter("color");
        brand = request.getParameter("brand");
        comments = request.getParameter("comments");
        model = request.getParameter("model");
        vehicleTypeId = request.getParameter("vehicleTypeId");//TODO: metodo para obtener vehicleTypeById
        parkingLotName = request.getParameter("uno");//TODO: metodo para obtener parkingLotByName
        VehicleType vehicleType = new VehicleType();

        //Create a new Vehicle
        Vehicle vehicle = new Vehicle(plate, color, brand, comments, model, vehicleType);
//        request.setAttribute("vehicle", vehicle);

        request.setAttribute("plate", plate);
        request.setAttribute("color", color);
        request.setAttribute("brand", brand);
        request.setAttribute("comments", comments);
        request.setAttribute("model", model);
        request.setAttribute("vehicleTypeId", vehicleTypeId);

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
        try {
            processRequest(request, response);
            //TODO: insertVehicle in parkingLot and save it in the file
            System.out.println("Estoy en doPost VehicleServlet");

//            String plate = request.getParameter("placa");
            response.getWriter().print("<p> La variable vale " + plate + "</p>");
//            String color = request.getParameter("color");
//            String brand = request.getParameter("brand");
//            String comments = request.getParameter("comments");
//            String model = request.getParameter("model");
//            String vehicleTypeId = request.getParameter("vehicleTypeId");//TODO: metodo para obtener vehicleTypeById
//            String parkingLotName = request.getParameter("parkingLotName");//TODO: metodo para obtener parkingLotByName
            VehicleType vehicleType = new VehicleType(1, "prueba", (byte) 4, (float) 234);

            //Create a new Vehicle
            Vehicle vehicle = new Vehicle(plate, color, brand, comments, model, vehicleType);
            ParkingLot parkingLot = parkingLotBusiness.getParkingLotByName("Parque del Norte");

            try {
                //Insert the vehicle in ParkingLot
                int spaceGiven = parkingLotBusiness.registerVehicleInParkingLot(vehicle, parkingLot);
            } catch (ParseException ex) {
                Logger.getLogger(VehicleInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispacher = request.getRequestDispatcher("register_customer_to_vehicle.jsp");
            dispacher.forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(VehicleInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
