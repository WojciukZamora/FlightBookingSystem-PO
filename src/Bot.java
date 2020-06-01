import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random
import java.util.Scanner;

public class Bot {
    private Client client;
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
        int idNumber;
        String companyName;
        int companyId;
        int los=generator.nextInt(50);
        Scanner readRandomCilients = new Scanner(new File("Files/RandomClients.txt"));
        for(int i =0;i<los;i++){
            readRandomCilients.nextLine();
        }
        if (readRandomCilients.next()=="Person"){
            firstname=readRandomCilients.next();
            surname=readRandomCilients.next();
            idNumber=readRandomCilients.nextInt();
            client= new Person(firstname,surname,idNumber);


        }
        if (readRandomCilients.next()=="Firm"){
            companyName=readRandomCilients.next();
            companyId=readRandomCilients.nextInt();
            client=new Firm(companyName,companyId);


        }

        return client;
    }
}
