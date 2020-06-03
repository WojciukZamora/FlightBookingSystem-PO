/**
 * @author Paweł Wojciuk
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Bot {
    private Firm firm;
    private Person person;
    private int wantedChairs;
    private int randomClientsAmount;
    Random generator = new Random();

    public int getRandomClientsAmount(int freeChairs){
        randomClientsAmount=generator.nextInt(freeChairs);
        return randomClientsAmount;
    }

    public Client getRandomClient() throws FileNotFoundException {
        String firstname;
        String surname;
        long idNumber;
        String companyName;
        int companyId;
        int los=generator.nextInt(50);
        Scanner readRandomCilients = new Scanner(new File("Files/RandomClients.txt"));
        for(int i =0;i<los;i++){
            readRandomCilients.nextLine();
        }
        String clientType =readRandomCilients.next();
        if (clientType.equals("Person")){
            firstname=readRandomCilients.next();
            surname=readRandomCilients.next();
            idNumber=readRandomCilients.nextLong();
            person= new Person(firstname,surname,idNumber);

            return person;

        }
        else {
            companyName=readRandomCilients.next();
            companyId=readRandomCilients.nextInt();
            firm=new Firm(companyName,companyId);

            return firm;
        }


    }
}
