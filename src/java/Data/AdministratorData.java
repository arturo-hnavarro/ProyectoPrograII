package Data;

import Domain.Administrator;
import java.util.LinkedList;

/**
 *
 * @author Samuel
 */
public class AdministratorData extends CustomerData{
    static LinkedList<Administrator> administrators;

    public AdministratorData() {
        administrators = null;
    }

    public void insertAdministrator(Administrator administrator) {

        administrators.add(administrator);
    }

    public void removeAdministrator(Administrator administrator) {

        administrators.remove(administrator);
    }

    public LinkedList<Administrator> getAllAdministrators() {
        return administrators;
    }

    public Administrator findAdministrartorById(String AdmnistratorId) {
        Administrator administrator = null;
        for (Administrator currentAdministrator : administrators) {
            if (currentAdministrator.getIdentification().equalsIgnoreCase(AdmnistratorId)) {
                administrator = currentAdministrator;
            }
        }
        return administrator;
    }
}