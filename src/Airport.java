import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Andrzej Zamora
 */
public class Airport {
    //Airport
    private String country,city,sizeType;
    private int airportSize;
    private String directType;
    private double localizationX,localizationY;

    //Plane
    private String name;
    private int planeSize,maxDistance;
    private String destiny;
    private int serialNr;
    private Boolean availibility;
    private int velocity;

    //Flight
    private int nr;
    private String fromCountry;
    private String fromCity;
    private String toCountry;
    private String toCity;
    private Plane plane;
    private Double distance;
    private OurDate startTime;
    private OurDate endTime;

    //Client
    private String firstName;




    private Client client;
    private List<Client> clients;

    //private Plane plane;
    private LinkedList<Plane>planes = new LinkedList<>();
    private Flight flight;
    private LinkedList<Flight>flights = new LinkedList<>();
    private String filePrefix;
    private Scanner console = new Scanner(System.in);

    public Airport(String country, String city, String sizeType, int airportSize, String directType, double localizationX, double localizationY) {
        this.country = country;
        this.city = city;
        this.sizeType = sizeType;
        this.airportSize = airportSize;
        this.directType = directType;
        this.localizationX = localizationX;
        this.localizationY = localizationY;
        filePrefix = country + '-' + city;
    }
    public void importPlanes() throws FileNotFoundException {
        Scanner readPlanes = new Scanner(new File("Files/Airports/" + filePrefix + "/" + filePrefix + "Planes.txt"));
        while(readPlanes.hasNextLine()) {
            serialNr = readPlanes.nextInt();
            Scanner readPlane = new Scanner(new File("Files/Planes/" + serialNr + ".txt"));
            name = readPlane.next();
            planeSize = readPlane.nextInt();
            maxDistance = readPlane.nextInt();
            destiny = readPlane.next();
            serialNr = readPlane.nextInt();
            availibility = readPlane.nextBoolean();
            velocity = readPlane.nextInt();
            planes.add(new Plane(name,planeSize,maxDistance,destiny,serialNr,availibility,velocity));
        }
    }
    public void importFlights() throws FileNotFoundException {
        Scanner readFlights = new Scanner(new File("Files/Airports/" + filePrefix + "/" + filePrefix + "Flights.txt"));
        while(readFlights.hasNextLine()) {
            nr = readFlights.nextInt();
            Scanner readFlight = new Scanner(new File("Files/Flights/" + nr +".txt"));
            nr = readFlight.nextInt();
            fromCountry = readFlight.next();
            fromCity = readFlight.next();
            toCountry = readFlight.next();
            toCity = readFlight.next();
            plane;
            distance = readFlight.nextDouble();
            startTime;
            endTime;
            private List<Client> clients;
            while(readFlight.hasNextLine()) {
                type = readFlight.next();//firm or client
            }

        }

    }
    public void addPlane() {
        System.out.print("name: ");
        name = console.next();
        System.out.println("planeSize: ");
        planeSize = console.nextInt();
        System.out.println("maxDistance: ");
        maxDistance = console.nextInt();
        System.out.println("destiny: ");
        destiny = console.next();
        System.out.println("serialNr: ");
        serialNr = console.nextInt();
        System.out.println("availibility: ");
        availibility = console.nextBoolean();
        System.out.println("velocity: ");
        velocity = console.nextInt();
        planes.add(new Plane(name,planeSize,maxDistance,destiny,serialNr,availibility,velocity));
    }
}
