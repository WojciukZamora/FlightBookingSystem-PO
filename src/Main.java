/**
 * @author Andrzej Zamora
 * @author Paweł Wojciuk
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int choose,choose2;
        Scanner console = new Scanner(System.in);
        FlightAdministrationSystem admin = new FlightAdministrationSystem();
        admin.importAirports();
        Airport airport;
        System.out.println("Welcome to the Flight Administration System!");
        while(true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Manage airports");
            System.out.println("2. Manage clients");
            System.out.println("3. Manage planes");
            System.out.println("4. Manage flights");
            System.out.println("5. Exit application");
            System.out.print("Choose: ");
            choose = console.nextInt();

            System.out.println("HAHAHAH ");

            System.out.print("You chose: ");
            switch (choose){
                case 1:
                    System.out.println("Manage airports");
                    System.out.println("Available options:");
                    System.out.println("1. Add airport");
                    System.out.println("2. Remove airport");
                    System.out.println("3. Write out all airports");
                    System.out.println("Default. Go back to main menu");
                    System.out.print("Choose: ");
                    choose2 = console.nextInt();
                    switch(choose2) {
                        case 1:
                            airport = new Airport();
                            System.out.println("Enter data of airport you want to add:");
                            System.out.print("Country: ");
                            airport.setCountry(console.next());
                            System.out.print("City: ");
                            airport.setCity(console.next());
                            System.out.print("Type of size (BIG/SMALL): ");
                            airport.setSizeType(console.next());
                            System.out.print("Size: ");
                            airport.setAirportSize(console.nextInt());
                            System.out.print("Direct type (BUSINESS/TOURIST): ");
                            airport.setDirectType(console.next());
                            System.out.println("Co-ordinates:");
                            System.out.print("X: ");
                            airport.setLocalizationX(console.nextDouble());
                            System.out.print("Y: ");
                            airport.setLocalizationY(console.nextDouble());
                            admin.addAirport(airport);
                            break;
                        case 2:
                            airport = new Airport();
                            System.out.println("Enter data of airport you want to remove:");
                            System.out.print("Country: ");
                            airport.setCountry(console.next());
                            System.out.print("City: ");
                            airport.setCity(console.next());
                            admin.removeAirport(airport.getCountry(),airport.getCity());
                            break;
                        case 3:
                            admin.writeOutAirports();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println();//TODO: Stąd
                case 5:
                    admin.exportAirports();
                    break;
                default:
                    System.out.println("Podałeś błędną opcję");
                    break;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
