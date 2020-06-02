/**
 * @author Paweł Wojciuk
 */
public class Plane {
    private String name;
    private int planeSize;
    private int maxDistance;
    private String destiny;
    private int serialNr;
    private Boolean availability;
    private int velocity;
    /*public Plane(String name, int planeSize, int maxDistance, String destiny, int serialNr, boolean availability, int velocity)
    {
        this.name=name;
        this.planeSize=planeSize;
        this.maxDistance=maxDistance;
        this.destiny=destiny;
        this.serialNr=serialNr;
        this.availability=availability;
        this.velocity=velocity;

    }*/
    public String getName(){
        return name;
    }
    public int getMaxDistance(){
        return maxDistance;
    }
    public String getType(){
        return destiny;
    }
    public int getSize(){
        return planeSize;
    }
    public int getSerialNr(){
        return serialNr;
    }
    public int getPlaneSize() {
        return planeSize;
    }
    public String getDestiny() {
        return destiny;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaneSize(int planeSize) {
        this.planeSize = planeSize;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setSerialNr(int serialNr) {
        this.serialNr = serialNr;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}