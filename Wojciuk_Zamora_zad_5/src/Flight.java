/**
 * @author Paweł Wojciuk
 */
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import  java.util.List;
import java.io.File;
import java.io.FileNotFoundException;


public class Flight {
    Firm firm;
    Person person;
    private int nr;
    private String fromCountry;
    private String fromCity;
    private String toCountry;
    private String toCity;
    private Plane plane;
    private Double distance;
    private OurDate startTime;
    private OurDate endTime;
    private LinkedList<Client> clients = new LinkedList<>();
    //client
    private String firstname;
    private String surname;
    private long idNumber;
    private String companyName;
    private int companyId;
    public Flight() {
        this.nr = 0;
        this.fromCountry = "";
        this.fromCity = "";
        this.toCountry = "";
        this.toCity = "";
        this.plane = null;
        this.distance = 0.0;
        this.startTime = null;
        this.endTime = null;
    }
    public Flight(Flight flight) {
        this.nr = flight.nr;
        this.fromCountry = flight.fromCountry;
        this.fromCity = flight.fromCity;
        this.toCountry = flight.toCountry;
        this.toCity = flight.toCity;
        this.plane = flight.plane;
        this.distance = flight.distance;
        this.startTime = flight.startTime;
        this.endTime = flight.endTime;
        this.clients = flight.clients;
    }

    public int getNr(){
        return nr;
    }
    public String getFromCity() {
        return fromCity;
    }
    public String getFromCountry() {
        return fromCountry;
    }
    public String getToCity() {
        return toCity;
    }
    public String getToCountry() {
        return toCountry;
    }
    public OurDate getStartTime() {
        return startTime;
    }
    public OurDate getEndTime() {
        return endTime;
    }
    public Plane getPlane() {
        return plane;
    }
    public double getDistance() {
        return distance;
    }
    public void addClient(Client client){
        clients.add(client);
    }
    public void removeClient(int seatNr){
        clients.remove((seatNr-1));
    }
    public LinkedList<Client> getClients(){
        return clients;
    }
    public int getClientsListSize(){ return  clients.size();}
    public int getFreeChairs(){
        return (plane.getSize()-clients.size());
    }

    public void importClients() throws FileNotFoundException{
        Scanner readClients = new Scanner(new File("Files/Flights/" +nr+"/"+nr+"Clients.txt"));
        while(readClients.hasNextLine()){
            String clientType = readClients.next();
            if (clientType.equals("Person")){
                firstname=readClients.next();
                surname=readClients.next();
                idNumber=readClients.nextLong();
                person= new Person(firstname,surname,idNumber);
                clients.add(person);

            }
            if (clientType.equals("Firm")){
                companyName=readClients.next();
                companyId=readClients.nextInt();
                firm=new Firm(companyName,companyId);
                clients.add(firm);

            }

            }
        }


    public void exportClients() throws FileNotFoundException{
        PrintWriter writeFlight= new PrintWriter(new File("Files/Flights/" +nr+"/"+nr+"Clients.txt"));
        int i=0;
        for(Object x : clients){
            i++;
            if(i!=1)writeFlight.println();

            if(x instanceof Firm){
                writeFlight.print("Firm"+" "+((Firm)x).getCompanyName()+" "+((Firm)x).getCompanyId());
            }
            if(x instanceof Person){
                writeFlight.print("Person"+" "+((Person)x).getFirstname()+" "+((Person)x).getSurname()+" "+((Person)x).getIdNumber());
            }
        }
        writeFlight.close();




    }

    public void setNr(int nr) {
        this.nr = nr;
    }


    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public void setStartTime(OurDate startTime){
    this.startTime=startTime;
    }

    public void setEndTime(OurDate endTime){
    this.endTime=endTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "nr=" + nr +
                ", fromCountry='" + fromCountry +
                ", fromCity='" + fromCity +
                ", toCountry='" + toCountry +
                ", toCity='" + toCity +
                ", plane=" + plane +
                ", distance=" + distance +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}