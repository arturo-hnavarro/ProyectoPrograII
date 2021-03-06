/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Esteban
 */
public class Customer extends User implements Employee {

    private boolean disabilityPresented;

    public Customer() {
        super();
    }

    public Customer(boolean disabilityPresented, String identification, String name, String username, String password, String role) {
        super(identification, name, username, password, role);
        this.disabilityPresented = disabilityPresented;
    }

    public boolean isDisabilityPresented() {
        return disabilityPresented;
    }

    public void setDisabilityPresented(boolean disabilityPresented) {
        this.disabilityPresented = disabilityPresented;
    }

    @Override
    public boolean verifyUserLogin(String[] loginDetails) {
        boolean isLoginSuccesful = false;

        if (loginDetails[0].equalsIgnoreCase(this.getUsername()) && loginDetails[1].equals(this.getPassword())) {
            isLoginSuccesful = true;
        }

        return isLoginSuccesful;
    }

    @Override
    public float calculateSalary(float dailySalary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Customer{" + "disabilityPresented=" + disabilityPresented + '}' + super.toString();
    }
}
