import java.util.Scanner;

public class User {
    private Client client;
    private int wantedChairs;
    private Scanner console = new Scanner(System.in);
    public Client readClient(){
        String firstname;
        String surname;
        int idNumber;
        String companyName;
        int companyId;
        String choose;
        System.out.println("Choose type of ticket: firm or person");
        choose= console.next();
        if(choose=="firm"||choose=="Firm"){
            System.out.println("company name:");
            companyName= console.next();
            System.out.println("companyId:");
            companyId = console.nextInt();
            client=new Firm(companyName,companyId);
        }
        if(choose=="person"||choose=="Person"){
            System.out.println("firstname:");
            firstname= console.next();
            System.out.println("surnamename:");
            surname= console.next();
            System.out.println("ID:");
            idNumber = console.nextInt();
            client=new Person(firstname,surname,idNumber);
        }
        else{
            client=new Firm("ErrorWrongTypeOfTicket-1",1)

        }
        return client;
    }
}
