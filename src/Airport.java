import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Andrzej Zamora
 */
public class Airport {
    private String country,city,sizeType;
    private int airportSize;
    private String directType;
    private double localizationX,localizationY;
    private Plane plane;

    private String name;
    private int planeSize;
    private int maxDistance;
    private String destiny;
    private int serialNr;
    private Boolean availibility;
    private int velocity;

    private LinkedList<Plane>planes = new LinkedList<>();
    private Flight flight;
    private LinkedList<Flight>flights = new LinkedList<>();
    private String filePrefix;

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
    public void importPlanes() {
        Scanner readPlanes = new Scanner(new File("Files/Airports/" + filePrefix + "/" + filePrefix + "Planes.txt"));
        while(readPlanes.hasNextLine()){
            serialNr = readPlanes.nextInt();
            Scanner readPlane = new Scanner(new File("Files/Planes/"+serialNr+".txt"));//TODO dokończyć!
        }
    }
}
