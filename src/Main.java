/**
 * @author Andrzej Zamora
 * @author Paweł Wojciuk
 */
import java.io.FileNotFoundException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FlightAdministrationSystem admin = new FlightAdministrationSystem();
        admin.importAirports();


        admin.exportAirports();
    }
}
