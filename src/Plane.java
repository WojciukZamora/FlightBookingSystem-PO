/**
 * @author Paweł Wojciuk
 */
public class Plane {
    private String name;
    private int size;
    private int maxDistance;
    private String directType;
    private int serialNr;
    private Boolean availability;
    private int velocity;
    public Plane(String name, int size, int maxDistance, String directType, int serialNr, boolean availability, int velocity)
    {
        this.name=name;
        this.size=size;
        this.maxDistance=maxDistance;
        this.directType=directType;
        this.serialNr=serialNr;
        this.availability=availability;
        this.velocity=velocity;

    }
    public String getName(){
        return name;
    }
    public int getMaxDistance(){
        return maxDistance;
    }
    public String getType(){
        return directType;
    }
    public int getSize(){
        return size;
    }
    public int getSerialNr(){
        return serialNr;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public int getVelocity() {
        return velocity;
    }
    public void setAvailability(Boolean availability){
        this.availability=availability;
    }
}