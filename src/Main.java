/**
 * @author Andrzej Zamora
 * @author Paweł Wojciuk
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        FlightAdministrationSystem admin = new FlightAdministrationSystem();
        admin.importAirports();
        System.out.println("Witaj w systemie zarządzania lotami.");
        System.out.println("1. Zarządzaj lotniskami");
        System.out.println("2. Zarządzaj kientami");
        System.out.println("3. Zarządzaj samolotami");
        System.out.println("4. Zarządazaj lotami");
        System.out.println("5. Zakończ działanie programu");

        System.out.println("HAHAHAH");

        int x;
        switch (x){
            case 1:
                System.out.println("Sprawawdź dostępne lotniska:");
                break;
            case 2:
                sout
        }




        admin.exportAirports();
    }
}
