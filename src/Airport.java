import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


/**
 * @author Andrzej Zamora
 */
public class Airport {
    private static int flightNumber = 132578;

    //Airport
    private String country;
    private String city;
    private String sizeType;
    private int airportSize;
    private String directType;
    private double localizationX;
    private double localizationY;

    private int day,month,year,hour;


    private Plane plane;
    private LinkedList<Plane>planes = new LinkedList<>();
    private ListIterator<Plane> itPlanes;
    private Flight flight;
    private LinkedList<Flight>flights = new LinkedList<>();
    private ListIterator<Flight> itFlights;
    private String airportName;
    private Scanner console = new Scanner(System.in);

    public Airport(String country, String city, String sizeType, int airportSize, String directType, double localizationX, double localizationY) {
        this.country = country;
        this.city = city;
        this.sizeType = sizeType;
        this.airportSize = airportSize;
        this.directType = directType;
        this.localizationX = localizationX;
        this.localizationY = localizationY;
        airportName = country + '_' + city;
    }
    public void importPlanes() throws FileNotFoundException {
        Scanner readPlanes = new Scanner(new File("Files/Airports/" + airportName + "/" + airportName + "Planes.txt"));
        while(readPlanes.hasNextLine()) {
            //plane = new Plane();
            plane.setSerialNr(readPlanes.nextInt());
            planes.add(importPlane(plane.getSerialNr()));
        }
    }
    private Plane importPlane(int serialNr_param) throws FileNotFoundException {
        Scanner readPlane = new Scanner(new File("Files/Planes/" + serialNr_param + ".txt"));
        plane.setName(readPlane.next());
        plane.setPlaneSize(readPlane.nextInt());
        plane.setMaxDistance(readPlane.nextInt());
        plane.setDestiny(readPlane.next());
        plane.setSerialNr(readPlane.nextInt());
        plane.setAvailability(readPlane.nextBoolean());
        plane.setVelocity(readPlane.nextInt());
        return plane;
    }
    public void importFlights() throws FileNotFoundException {
        Scanner readFlights = new Scanner(new File("Files/Airports/" + airportName + "/" + airportName + "Flights.txt"));
        while(readFlights.hasNextLine()) {
            flight.setNr(readFlights.nextInt());
            Scanner readFlightInfo = new Scanner(new File("Files/Flights/" + flight.getNr() + "/" + flight.getNr() + "Info.txt"));
            flight.setNr(readFlightInfo.nextInt());
            flight.setFromCountry(readFlightInfo.next());
            flight.setFromCity(readFlightInfo.next());
            flight.setToCountry(readFlightInfo.next());
            flight.setToCity(readFlightInfo.next());
            int serialNr = readFlightInfo.nextInt();
            flight.setPlane(importPlane(serialNr));
            flight.setDistance(readFlightInfo.nextDouble());
            day = readFlightInfo.nextInt();
            month = readFlightInfo.nextInt();
            year = readFlightInfo.nextInt();
            hour = readFlightInfo.nextInt();
            flight.setStartTime(new OurDate(day,month,year,hour));
            day = readFlightInfo.nextInt();
            month = readFlightInfo.nextInt();
            year = readFlightInfo.nextInt();
            hour = readFlightInfo.nextInt();
            flight.setEndTime(new OurDate(day,month,year,hour));
            flight.importClients();
            flights.add(flight);
        }
    }
    public void addPlane(Plane plane) {
        planes.add(plane);
    }
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removePlane(int serialNr) {
        itPlanes = planes.listIterator();
        while(itPlanes.hasNext()) {
            Plane plane = itPlanes.next();
            if(plane.getSerialNr() == serialNr) {
                itPlanes.remove();
                System.out.println("Plane deleted");
                return;
            }
        }
    }

    public void removeFlight(int nr) {
        itFlights = flights.listIterator();
        while(itFlights.hasNext()) {
            Flight flight = itFlights.next();
            if(flight.getNr() == nr) {
                itFlights.remove();
                //TODO: może wrzucenie na historię zamiast usuwać??
                System.out.println("Flight deleted");
                return;
            }
        }
    }

    public void exportPlanes() throws FileNotFoundException {
        PrintWriter writePlanes = new PrintWriter(new File("Files/Airports/" + airportName + "/" + airportName + "Planes.txt"));
        itPlanes = planes.listIterator();
        while(itPlanes.hasNext()) {
            Plane plane = itPlanes.next();
            writePlanes.println(plane.getSerialNr());
        }
    }
    public void exportFlights() throws FileNotFoundException {
        PrintWriter writeFlights = new PrintWriter(new File("Files/Airports/" + airportName + "/" + airportName + "Flights.txt"));
        itFlights = flights.listIterator();
        while(itFlights.hasNext()) {
            Flight flight = itFlights.next();
            writeFlights.println(flight.getNr());
        }
    }





    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public int getAirportSize() {
        return airportSize;
    }

    public void setAirportSize(int airportSize) {
        this.airportSize = airportSize;
    }

    public String getDirectType() {
        return directType;
    }

    public void setDirectType(String directType) {
        this.directType = directType;
    }

    public double getLocalizationX() {
        return localizationX;
    }

    public void setLocalizationX(double localizationX) {
        this.localizationX = localizationX;
    }

    public double getLocalizationY() {
        return localizationY;
    }

    public void setLocalizationY(double localizationY) {
        this.localizationY = localizationY;
    }
}
