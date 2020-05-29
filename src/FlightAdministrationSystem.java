import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author Andrzej Zamora
 */
public class FlightAdministrationSystem {
    Airport airport;
    static LinkedList<Airport> airports = new LinkedList<>();
    static ListIterator<Airport> it;

    public void importAirports() throws FileNotFoundException {
        Scanner readAirports = new Scanner(new File("Files/Airports.txt"));
        String filePrefix;
        String country, city, sizeType;
        int size;
        String directType;
        double localizationX, localizationY;

        while (readAirports.hasNextLine()) {
            country = readAirports.next();
            city = readAirports.next();
            filePrefix = country + '_' + city;
            Scanner readAirport = new Scanner(new File("Files/Airports/" + filePrefix + "/" + filePrefix + "Info.txt"));
            while (readAirport.hasNextLine()) {
                country = readAirport.next();
                city = readAirport.next();
                sizeType = readAirport.next();
                size = readAirport.nextInt();
                directType = readAirport.next();
                localizationX = readAirport.nextDouble();
                localizationY = readAirport.nextDouble();
                airport = new Airport(country, city, sizeType, size, directType, localizationX, localizationY);
                airport.importPlanes();
                airport.importFlights();
            }
        }
    }

    public void addAirport(Airport airport) {
        airports.add(airport);
    }

    public static LinkedList<Airport> getAirports() {
        return airports;
    }

    public void removeAirport(String country, String city) {
        it = airports.listIterator();
        while (it.hasNext()) {
            Airport airport = it.next();
            if (airport.getCountry().equals(country) && airport.getCity().equals(city)) {
                it.remove();
                System.out.println("Pomyślnie usunięto lotnisko z bazy");
                return;
            }
        }
    }

    public void exportAirports() {
        //TODO!!
    }


}
