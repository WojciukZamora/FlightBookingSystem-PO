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
    private  LinkedList<Client> clients = new LinkedList<>();
    //client
    private String firstname;
    private String surname;
    private int idNumber;
    private String companyName;
    private int companyId;
    public Flight(int nr, String fromCountry,String fromCity, String toCountry, String toCity, Plane plane,Double xFrom,Double yFrom,Double xTo,Double yTo, OurDate startTime){
        this.nr=nr;
        this.fromCity=fromCity;
        this.fromCountry=fromCountry;
        this.toCity=toCity;
        this.toCountry=toCountry;
        this.plane=plane;
        this.distance=Math.sqrt(Math.pow((xFrom-xTo),2)+Math.pow((yFrom-yTo),2));
        this.startTime=startTime;
        /**this.endTime=startTime+2hour+Math.round(distance/plane.getVelocity)hour
         *
         */



    }
    public Flight(int nr, String fromCountry,String fromCity, String toCountry, String toCity, Plane plane,Double distance, OurDate startTime,OurDate endTime){
        this.nr=nr;
        this.fromCity=fromCity;
        this.fromCountry=fromCountry;
        this.toCity=toCity;
        this.toCountry=toCountry;
        this.plane=plane;
        this.distance=distance;
        this.startTime=startTime;
        this.endTime=endTime;
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
    public void addClient(Client client){
        clients.add(client);
    }
    public void removeClient(int seatNr){
        clients.remove((seatNr-1));
    }
    public List<Client> getClients(){
        return clients;
    }
    public int getFreeChairs(){
        return (plane.getSize()-clients.size());
    }
    public void importClients() throws FileNotFoundException{
        Scanner readCilients = new Scanner(new File("Files/Flights/" +nr+"Clients.txt"));
        while(readCilients.hasNextLine()){
            if (readCilients.next()=="Person"){
                firstname=readCilients.next();
                surname=readCilients.next();
                idNumber=readCilients.nextInt();
                person= new Person(firstname,surname,idNumber);
                clients.add(person);

            }
            if (readCilients.next()=="Firm"){
                companyName=readCilients.next();
                companyId=readCilients.nextInt();
                firm=new Firm(companyName,companyId);
                clients.add(firm);

            }

            }
        }

    }
    public void exportClients() throws FileNotFoundException{
        PrintWriter writeFlight= new PrintWriter(new File("Files/Flights/" +nr+"Clients.txt"));
        for(Object x : clients){
            if(x instanceof Firm){
                writeFlight.println("Firm"+" "+((Firm)x).getCompanyName()+" "+((Firm)x).getCompanyId());

            }
            if(x instanceof Person){
                writeFlight.println("Person"+" "+((Person)x).getFirstname()+" "+((Person)x).getSurname()+" "+((Person)x).getIdNumber());

            }
            writeFlight.close();
        }




    }
}