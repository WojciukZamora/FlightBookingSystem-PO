/**
 * @author Andrzej Zamora
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Scanner;

public class FlightAdministrationSystem {
    Airport airport;
    private LinkedList<Airport> airports = new LinkedList<>();
    private ListIterator<Airport> it;
    private String airportName;
    private Plane plane;
    private Flight flight;
    private Scanner console = new Scanner(System.in);
    private static int flightNumber = 132578;

    public void importAirports() throws FileNotFoundException {
        Scanner readAirports = new Scanner(new File("Files/Airports.txt"));
        while (readAirports.hasNextLine()) {
            airport = new Airport();
            airport.setCountry(readAirports.next());
            airport.setCity(readAirports.next());
            airportName = airport.getCountry() + '_' + airport.getCity();
            Scanner readAirport = new Scanner(new File("Files/Airports/" + airportName + "/" + airportName + "Info.txt"));
            readAirport.useLocale(Locale.US);
            airport.setCountry(readAirport.next());
            airport.setCity(readAirport.next());
            airport.setSizeType(readAirport.next());
            airport.setAirportSize(readAirport.nextInt());
            airport.setDirectType(readAirport.next());
            airport.setX(readAirport.nextDouble());
            airport.setY(readAirport.nextDouble());
            airport.importPlanes();
            airport.importFlights();
            airports.add(airport);
        }
    }

    public void addAirport(Airport airport) {
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
        System.out.println("No airport found in that City and Country");
    }

    public void writeOutAirports() {
        for (Airport airport : airports) {
            System.out.println(airport);
        }
    }
    public void addPlane(Plane plane, String country, String city) {
        it = airports.listIterator();
        while (it.hasNext()) {
            Airport airport = it.next();
            if (airport.getCountry().equals(country) && airport.getCity().equals(city)) {
                airport.addPlane(plane);
                System.out.println("Plane added");
                return;
            }
        }
        System.out.println("No airport found in that City and Country");
    }
    public void removePlane(int serialNr, String country, String city) {
        it = airports.listIterator();
        while (it.hasNext()) {
            Airport airport = it.next();
            if (airport.getCountry().equals(country) && airport.getCity().equals(city)) {
                airport.removePlane(serialNr);
                System.out.println("Plane removed");
                return;
            }
        }
        System.out.println("No airport found in that City and Country");
    }
    public void writeOutPlanes(String country, String city) {
        it = airports.listIterator();
        while (it.hasNext()) {
            Airport airport = it.next();
            if (airport.getCountry().equals(country) && airport.getCity().equals(city)) {
                airport.writeOutPlanes();
            }
        }
    }

    public Airport searchAirportByCountryCity(String country, String city) {
        it = airports.listIterator();
        while (it.hasNext()) {
            Airport airport = it.next();
            if (airport.getCountry().equals(country) && airport.getCity().equals(city))
                return airport;
        }
        return null;
    }



    public void exportAirports() throws FileNotFoundException {
        PrintWriter writeAirports = new PrintWriter(new File("Files/Airports.txt"));
        int i=0;
        for (Airport airport : airports) {
            i++;
            if(i!=1)writeAirports.println();
            writeAirports.print(airport.getCountry() + " " + airport.getCity());
            airportName = airport.getCountry() + '_' + airport.getCity();
            new File("Files/Airports/" + airportName + "/" + airportName).mkdirs();
            PrintWriter writeAirport = new PrintWriter(new File("Files/Airports/" + airportName + "/" + airportName + "Info.txt"));
            writeAirport.println(airport.getCountry());
            writeAirport.println(airport.getCity());
            writeAirport.println(airport.getSizeType());
            writeAirport.println(airport.getAirportSize());
            writeAirport.println(airport.getDirectType());
            writeAirport.println(airport.getX());
            writeAirport.println(airport.getY());
            airport.exportPlanes();
            airport.exportFlights();
            writeAirport.close();
        }
        writeAirports.close();
    }


}
