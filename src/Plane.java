/**
 * @author Paweł Wojciuk
 */
public class Plane {
    private String name;
    private Integer size;
    private Integer maxDistance;
    private String directType;
    private Integer serialNr;
    private Boolean availability;
    private Integer velocity;
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
    public Integer getMaxDistance(){
        return maxDistance;
    }
    public String getType(){
        return directType;
    }
    public Integer getSize(){
        return size;
    }
    public Integer getSerialNr(){
        return serialNr;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public Integer getVelocity() {
        return velocity;
    }
    public void setAvailability(Boolean availability){
        this.availability=availability;
    }
}
