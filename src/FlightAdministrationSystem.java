import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    private String airportName;
    private Scanner console = new Scanner(System.in);

    public void importAirports() throws FileNotFoundException {
        Scanner readAirports = new Scanner(new File("Files/Airports.txt"));
        while (readAirports.hasNextLine()) {
            airport.setCountry(readAirports.next());
            airport.setCity(readAirports.next());
            airportName = airport.getCountry() + '_' + airport.getCity();
            Scanner readAirport = new Scanner(new File("Files/Airports/" + airportName + "/" + airportName + "Info.txt"));
            airport.setCountry(readAirport.next());
            airport.setCity(readAirport.next());
            airport.setSizeType(readAirport.next());
            airport.setAirportSize(readAirport.nextInt());
            airport.setDirectType(readAirport.next());
            airport.setLocalizationX(readAirport.nextDouble());
            airport.setLocalizationY(readAirport.nextDouble());
            airport.importPlanes();
            airport.importFlights();
            airports.add(airport);
        }
    }

    public void addAirport(Airport airport) {
        /*System.out.print("Country: ");
        airport.setCountry(console.next());
        System.out.print("City: ");
        airport.setCity(console.next());
        System.out.print("sizeType: ");
        airport.setSizeType(console.next());
        System.out.print("airportSize: ");
        airport.setAirportSize(console.nextInt());
        System.out.print("directType: ");
        airport.setDirectType(console.next());
        System.out.print("localizationX: ");
        airport.setLocalizationX(console.nextDouble());
        System.out.print("localizationY: ");
        airport.setLocalizationY(console.nextDouble());*/
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
                System.out.println("Airport deleted");
                return;
            }
        }
    }

    public void exportAirports() throws FileNotFoundException {
        PrintWriter writeAirports = new PrintWriter(new File("Files/Airports.txt"));
        for (airport : airports) {
            writeAirports.println(airport.getCountry() + " " + this.airport.getCity());
            airportName = airport.getCountry() + '_' + airport.getCity();
            PrintWriter writeAirport = new PrintWriter(new File("Files/Airports/" + airportName + "/" + airportName + "Info.txt"));
            writeAirport.println(airport.getCountry());
            writeAirport.println(airport.getCity());
            writeAirport.println(airport.getSizeType());
            writeAirport.println(airport.getAirportSize());
            writeAirport.println(airport.getDirectType());
            writeAirport.println(airport.getLocalizationX());
            writeAirport.println(airport.getLocalizationY());
            airport.exportPlanes();
            airport.exportFlights();
        }
    }


}
