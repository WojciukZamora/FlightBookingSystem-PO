/**
 * @author Andrzej Zamora
 * @author Paweł Wojciuk
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner readTime = new Scanner(new File("Files/Time.txt"));
        int day,month,year,hour;
        day = readTime.nextInt();
        month = readTime.nextInt();
        year = readTime.nextInt();
        hour = readTime.nextInt();
        OurDate currTime = new OurDate(day,month,year,hour);



        int choose,choose2;
        Client client;
        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);
        FlightAdministrationSystem admin = new FlightAdministrationSystem();
        admin.importAirports();
        Airport airport;
        Plane plane;
        Flight flight;
        System.out.println("Welcome to the Flight Administration System!");
        while(true) {
            //BOT5

            Bot bot=new Bot();
            if(currTime.getHour() == 1) {
                for(Airport x : admin.getAirports()){
                    for(Flight y : (x).getFlights()){
                        for(int i=0; i<bot.getRandomClientsAmount(y.getFreeChairs());i++){
                            client=bot.getRandomClient();
                            y.addClient(client);

                        }

                    }
                }
            }
            //BOT
            System.out.println("Current time: " + currTime.toString());
            System.out.println("What do you want to do?");
            System.out.println("1. Manage airports");
            System.out.println("2. Manage planes");
            System.out.println("3. Manage flights");
            System.out.println("4. Manage clients");
            System.out.println("5. Increase time by 1 hour");
            System.out.println("6. Exit application");
            System.out.print("Choose: ");
            choose = console.nextInt();
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
                    System.out.println("Manage planes");
                    System.out.println("Select airport whose resources you want to check:");
                    airport = new Airport();
                    System.out.print("Country: ");
                    airport.setCountry(console.next());
                    System.out.print("City: ");
                    airport.setCity(console.next());
                    System.out.println("Available options:");
                    System.out.println("1. Add plane to airport: " + airport.getCountry() + " " + airport.getCity());
                    System.out.println("2. Remove plane from airport: " + airport.getCountry() + " " + airport.getCity());
                    System.out.println("3. Write out all planes from airport: " + airport.getCountry() + " " + airport.getCity());
                    System.out.println("Default. Go back to main menu");
                    System.out.print("Choose: ");
                    choose2 = console.nextInt();
                    switch(choose2) {
                        case 1:
                            plane = new Plane();
                            System.out.println("Enter data of plane you want to add:");
                            System.out.print("Name: ");
                            plane.setName(console.next());
                            System.out.print("Size: ");
                            plane.setPlaneSize(console.nextInt());
                            System.out.print("MaxDistance: ");
                            plane.setMaxDistance(console.nextInt());
                            System.out.print("Destiny (Charter/Scheduled): ");
                            plane.setDestiny(console.next());
                            System.out.print("SerialNr: ");
                            plane.setSerialNr(console.nextInt());
                            plane.setAvailability(true);
                            System.out.print("Velocity: ");
                            plane.setVelocity(console.nextInt());
                            admin.addPlane(plane, airport.getCountry(), airport.getCity());
                            break;
                        case 2:
                            plane = new Plane();
                            System.out.println("Enter data of plane you want to remove:");
                            System.out.print("SerialNr: ");
                            plane.setSerialNr(console.nextInt());
                            admin.removePlane(plane.getSerialNr(),airport.getCountry(),airport.getCity());
                            break;
                        case 3:
                            admin.writeOutPlanes(airport.getCountry(),airport.getCity());
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    //
                    break;
                case 4:
                    break;
                case 5:
                    currTime.increase(1);
                    break;
                case 6:
                    System.out.println("Exit");
                    admin.exportAirports();
                    return;
                default:
                    System.out.println("Wrong option :(");
                    break;
            }
            System.out.println("Press enter to go forward");
            System.in.read();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
