/**
 * @author Andrzej Zamora
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

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
    private LinkedList<Plane>planes = new LinkedList<>();
    private LinkedList<Flight>flights = new LinkedList<>();


    private Plane plane;
    private ListIterator<Plane> itPlanes;
    private Flight flight;
    private ListIterator<Flight> itFlights;
    private int day,month,year,hour;
    private String airportName;
    private Scanner console = new Scanner(System.in);

    public void importPlanes() throws FileNotFoundException {
        airportName = country + '_' + city;
        Scanner readPlanes = new Scanner(new File("Files/Airports/" + airportName + "/" + airportName + "Planes.txt"));
        while(readPlanes.hasNextLine()) {
            plane = new Plane();
            importPlane(readPlanes.nextInt());
            planes.add(plane);
        }
    }
    private void importPlane(int serialNr_param) throws FileNotFoundException {
        Scanner readPlane = new Scanner(new File("Files/Planes/" + serialNr_param + ".txt"));
        plane = new Plane();
        plane.setName(readPlane.next());
        plane.setPlaneSize(readPlane.nextInt());
        plane.setMaxDistance(readPlane.nextInt());
        plane.setDestiny(readPlane.next());
        plane.setSerialNr(readPlane.nextInt());
        plane.setAvailability(readPlane.nextBoolean());
        plane.setVelocity(readPlane.nextInt());
    }
    public void importFlights() throws FileNotFoundException {
        airportName = country + '_' + city;
        Scanner readFlights = new Scanner(new File("Files/Airports/" + airportName + "/" + airportName + "Flights.txt"));
        while(readFlights.hasNextLine()) {
            flight = new Flight();
            flight.setNr(readFlights.nextInt());
            Scanner readFlightInfo = new Scanner(new File("Files/Flights/" + flight.getNr() + "/" + flight.getNr() + "Info.txt"));
            flight.setNr(readFlightInfo.nextInt());
            flight.setFromCountry(readFlightInfo.next());
            flight.setFromCity(readFlightInfo.next());
            flight.setToCountry(readFlightInfo.next());
            flight.setToCity(readFlightInfo.next());
            int serialNr = readFlightInfo.nextInt();
            importPlane(serialNr);
            flight.setPlane(plane);
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
        airportName = country + '_' + city;
        PrintWriter writePlanes = new PrintWriter(new File("Files/Airports/" + airportName + "/" + airportName + "Planes.txt"));
        itPlanes = planes.listIterator();
        int i=0;
        while(itPlanes.hasNext()) {
            if(++i!=1)writePlanes.println();
            Plane plane = itPlanes.next();
            writePlanes.print(plane.getSerialNr());
            PrintWriter writePlane = new PrintWriter(new File("Files/Planes/" + plane.getSerialNr() + ".txt"));
            writePlane.println(plane.getName());
            writePlane.println(plane.getPlaneSize());
            writePlane.println(plane.getMaxDistance());
            writePlane.println(plane.getDestiny());
            writePlane.println(plane.getSerialNr());
            writePlane.println(plane.getAvailability());
            writePlane.println(plane.getVelocity());
        }
        writePlanes.close();
    }
    public void exportFlights() throws FileNotFoundException {
        airportName = country + '_' + city;
        PrintWriter writeFlights = new PrintWriter(new File("Files/Airports/" + airportName + "/" + airportName + "Flights.txt"));
        itFlights = flights.listIterator();
        int i=0;
        while(itFlights.hasNext()) {
            if(++i!=1)writeFlights.println();
            Flight flight = itFlights.next();
            writeFlights.print(flight.getNr());
            PrintWriter writeFlight = new PrintWriter(new File("Files/Flights/" + flight.getNr() + "/" + flight.getNr() + ".txt"));
            writeFlight.println(flight.getNr());
            writeFlight.println(flight.getFromCountry());
            writeFlight.println(flight.getFromCity());
            writeFlight.println(flight.getToCountry());
            writeFlight.println(flight.getToCity());
            writeFlight.println(flight.getPlane().getSerialNr());
            writeFlight.println(flight.getDistance());
            writeFlight.println(flight.getStartTime().getDay());
            writeFlight.println(flight.getStartTime().getMonth());
            writeFlight.println(flight.getStartTime().getYear());
            writeFlight.println(flight.getStartTime().getHour());
            writeFlight.println(flight.getEndTime().getDay());
            writeFlight.println(flight.getEndTime().getMonth());
            writeFlight.println(flight.getEndTime().getYear());
            writeFlight.println(flight.getEndTime().getHour());
            flight.exportClients();
        }
        writeFlights.close();
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
