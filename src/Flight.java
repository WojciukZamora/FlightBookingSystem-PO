/**
 * @author Paweł Wojciuk
 */
import java.util.LinkedList;
import java.util.Date;
import  java.util.List;

public class Flight {
    private Integer nr;
    private String fromCountry;
    private String fromCity;
    private String toCountry;
    private String toCity;
    private Plane plane;
    private Double distance;
    private OurDate startTime;
    private OurDate endTime;
    private  List<Client> clients;
    public Flight(int nr, String fromCity, String fromCountry, String toCity, String toCountry, Plane plane,Double xFrom,Double yFrom,Double xTo,Double yTo, OurDate startTime){
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
        clients=new LinkedList<Client>();


    }
    public Integer getNr(){
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
    public void removeClient(Client client){
        clients.remove(client);
    }
    public List<Client> getClients(){
        return clients;
    }
    public Integer getFreeChairs(){
        return (plane.getSize()-clients.size());
    }
    public
}