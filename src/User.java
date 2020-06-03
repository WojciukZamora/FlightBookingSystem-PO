/**
 * @author Paweł Wojciuk
 */
import java.util.Scanner;

public class User {
    private Client client;
    private int wantedChairs;
    private Scanner console = new Scanner(System.in);
    public Client readClient(){
        String firstname;
        String surname;
        long idNumber;
        String companyName;
        int companyId;
        String choose;
        System.out.println("Choose type of ticket: firm or person");
        choose= console.next();
        if(choose.equals("firm")||choose.equals("Firm")){
            System.out.println("company name:");
            companyName= console.next();
            System.out.println("companyId:");
            companyId = console.nextInt();
            client=new Firm(companyName,companyId);
        }
        if(choose.equals("person")||choose.equals("Person")){
            System.out.println("firstname:");
            firstname= console.next();
            System.out.println("surname:");
            surname= console.next();
            System.out.println("ID:");
            idNumber = console.nextLong();
            client=new Person(firstname,surname,idNumber);
        }
        else{
            client=new Firm("ErrorWrongTypeOfTicket-1",1);

        }
        return client;
    }
}
