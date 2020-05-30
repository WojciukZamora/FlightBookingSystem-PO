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
    private LinkedList<Airport> airports = new LinkedList<>();
    private ListIterator<Airport> it;
    private String filePrefix;//protected??
    private String country, city, sizeType;
    private int airportSize;
    private String directType;
    private double localizationX, localizationY;
    Scanner console = new Scanner(System.in);

    public void importAirports() throws FileNotFoundException {
        Scanner readAirports = new Scanner(new File("Files/Airports.txt"));
        while (readAirports.hasNextLine()) {
            country = readAirports.next();
            city = readAirports.next();
            filePrefix = country + '_' + city;
            Scanner readAirport = new Scanner(new File("Files/Airports/" + filePrefix + "/" + filePrefix + "Info.txt"));
            while (readAirport.hasNextLine()) {
                country = readAirport.next();
                city = readAirport.next();
                sizeType = readAirport.next();
                airportSize = readAirport.nextInt();
                directType = readAirport.next();
                localizationX = readAirport.nextDouble();
                localizationY = readAirport.nextDouble();
                airport = new Airport(country, city, sizeType, airportSize, directType, localizationX, localizationY);
                airport.importPlanes();
                airport.importFlights();
                airports.add(airport);
            }
        }
    }

    public void addAirport() {
        System.out.print("Country: ");
        country = console.next();
        System.out.print("City: ");
        city = console.next();
        System.out.print("sizeType: ");
        sizeType = console.next();
        System.out.print("airportSize: ");
        airportSize = console.nextInt();
        System.out.print("directType: ");
        directType = console.next();
        System.out.print("localizationX: ");
        localizationX = console.nextDouble();
        System.out.print("localizationY: ");
        localizationY = console.nextDouble();
        airport = new Airport(country, city, sizeType, airportSize, directType, localizationX, localizationY);
        airports.add(airport);
    }

    public LinkedList<Airport> getAirports() {
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
