/**
 * @author Andrzej Zamora
 * @author Paweł Wojciuk
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner readTime = new Scanner(new File("Files/Time.txt"));
        Scanner readFlightNumber = new Scanner(new File("Files/FlightNumber.txt"));
        int day,month,year,hour;
        day = readTime.nextInt();
        month = readTime.nextInt();
        year = readTime.nextInt();
        hour = readTime.nextInt();
        OurDate currTime = new OurDate(day,month,year,hour);
        int flightNumber = readFlightNumber.nextInt();



        int choose,choose2;
        String choose3;
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
            User user = new User();
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
            cls();
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
                            airport.setX(console.nextDouble());
                            System.out.print("Y: ");
                            airport.setY(console.nextDouble());
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
                    System.out.println("Manage flights");
                    System.out.println("Select airport in which flight should start:");
                    airport = new Airport();
                    System.out.print("Country: ");
                    airport.setCountry(console.next());
                    System.out.print("City: ");
                    airport.setCity(console.next());
                    System.out.println("Available options:");
                    System.out.println("1. Add flight, which will start in airpoirt: " + airport.getCountry() + " " + airport.getCity());
                    System.out.println("2. Remove flight which starts from airport: " + airport.getCountry() + " " + airport.getCity());
                    System.out.println("3. Write out all flights starting from airport: " + airport.getCountry() + " " + airport.getCity());
                    System.out.println("Default. Go back to main menu");
                    System.out.print("Choose: ");
                    choose2 = console.nextInt();
                    switch(choose2) {
                        case 1:
                            flight = new Flight();
                            System.out.println("Enter data of flight you want to add:");
                            flight.setNr(++flightNumber);
                            flight.setFromCountry(airport.getCountry());
                            flight.setFromCity(airport.getCity());
                            System.out.print("Target country: ");
                            flight.setToCountry(console.next());
                            System.out.print("Target city: ");
                            flight.setToCity(console.next());
                            Airport airportFrom = admin.searchAirportByCountryCity(flight.getFromCountry(), flight.getFromCity());
                            Airport airportTo = admin.searchAirportByCountryCity(flight.getToCountry(), flight.getToCity());

                            System.out.print("Plane serialNr: ");
                            plane = new Plane();
                            plane.setSerialNr(console.nextInt());
                            flight.setPlane(airportFrom.searchPlaneBySerialNr(plane.getSerialNr()));
                            flight.setDistance(111*Math.sqrt(Math.pow((airportFrom.getX()-airportTo.getX()),2)+
                                                             Math.pow((airportFrom.getY()-airportTo.getY()),2)));
                            System.out.println("Enter start time:");
                            System.out.print("day: ");
                            day = console.nextInt();
                            System.out.print("month: ");
                            month = console.nextInt();
                            System.out.print("year: ");
                            year = console.nextInt();
                            System.out.print("hour: ");
                            hour = console.nextInt();
                            flight.setStartTime(new OurDate(day,month,year,hour));
                            OurDate tempTime1 = new OurDate(day,month,year,hour);
                            OurDate tempTime2 = new OurDate(day,month,year,hour);
                            tempTime2.increase(2 + (int)Math.round(flight.getDistance()/plane.getVelocity()));
                            flight.setEndTime(new OurDate(tempTime2));

                            airportFrom.addFlight(new Flight(flight));
                            System.out.println("Do you want the flight to be scheduled once a week for a year? (yes/no)");
                            choose3 = console.next();
                            if(choose3.equals("yes")) {
                                for(int i=1;i<=54;++i) {
                                    flight.setNr(++flightNumber);
                                    tempTime1.increase(168);
                                    tempTime2.increase(168);
                                    flight.setStartTime(new OurDate(tempTime1));
                                    flight.setEndTime(new OurDate(tempTime2));
                                    airportFrom.addFlight(new Flight(flight));
                                }
                            }
                            break;
                        case 2:
                            flight = new Flight();
                            System.out.println("Enter data of flight you want to remove:");
                            System.out.print("nr: ");
                            flight.setNr(console.nextInt());
                            airport = admin.searchAirportByCountryCity(airport.getCountry(), airport.getCity());
                            admin.airport.removeFlight(flight.getNr());
                            break;
                        case 3:
                            airport = admin.searchAirportByCountryCity(airport.getCountry(), airport.getCity());
                            airport.writeOutFlights();
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Manage clients");
                    System.out.println("Select airport in which flight should start:");
                    airport = new Airport();
                    System.out.print("Country: ");
                    airport.setCountry(console.next());
                    System.out.print("City: ");
                    airport.setCity(console.next());
                    airport = admin.searchAirportByCountryCity(airport.getCountry(), airport.getCity());

                    System.out.println("Select flight:");
                    flight = new Flight();
                    System.out.print("nr: ");
                    flight.setNr(console.nextInt());
                    flight = airport.searchFlightByNr(flight.getNr());
                    System.out.println("Available options:");
                    System.out.println("1. Add client to flight nr " + flight.getNr());
                    System.out.println("2. Remove client from flight nr " + flight.getNr());
                    System.out.println("3. Write out all clients from flight nr " + flight.getNr());
                    System.out.println("Default. Go back to main menu");
                    System.out.print("Choose: ");
                    choose2 = console.nextInt();
                    switch(choose2) {
                        case 1:
                            System.out.print("How many tickets you want to buy? ");
                            int ticketsAmount = console.nextInt();
                            client = user.readClient();
                            for(int i=0;i<ticketsAmount;++i) {
                                airport.flight.addClient(client);
                            }
                            break;
                        case 2:
                            System.out.print("Enter seatNr:");
                            int seatNr = console.nextInt();
                            airport.flight.removeClient(seatNr);
                            break;
                        case 3:
                            int i=0;
                            for(Client c : airport.flight.getClients()) {
                                System.out.println("seatNr: " + i + " " +(c).toString());
                                ++i;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    currTime.increase(1);
                    break;
                case 6:
                    System.out.println("Exit");
                    PrintWriter writeTime = new PrintWriter(new File("Files/Time.txt"));
                    writeTime.println(currTime.getDay() + " " + currTime.getMonth() + " " + currTime.getYear() + " " + currTime.getHour());
                    writeTime.close();
                    PrintWriter writeFlightNumber = new PrintWriter(new File("Files/FlightNumber.txt"));
                    writeFlightNumber.println(flightNumber);
                    writeFlightNumber.close();
                    admin.exportAirports();
                    return;
                default:
                    System.out.println("Wrong option :(");
                    break;
            }
            System.out.println("Press enter to go forward");
            System.in.read();
            cls();

        }

    }
    static void cls() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
