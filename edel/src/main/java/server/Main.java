// Viktor Köhlmark
// Är själva kilenten som användaren kommer styra funktionerna från

package server;

import java.util.Scanner;

public class Main {
    private static LibraryManager manager = new LibraryManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        IO.println("Hej");
        boolean running = true;
        while (running) {

            IO.println("""
                    Meny
                    1. Hämta information fårn servern 
                    2. Skriv ut hämtad data
                    3. Kotroll av kund 
                    4. Sök efter bok eller magazin 
                    5. Bok och magazin haterings system 
                    6. Kund hanterings system
                    7. Synca till servern 
                    8. Avsluta
                        """);

            String choice = scanner.nextLine();

            // switch (choice) {
            // case "1": manager.fetchData("/books");break;
            // case "2": manager.fetchData("/magazines");break;
            // case "3": manager.printAllItems();break;
            // case "4": manager.addItem(); break;
            // case "5": manager.sendToServer(); break;
            // case "6":
            // String title = IO.readln("Skriv titel på magazin eller bok");
            // manager.searchTitle(title);
            // break;
            // case "7": manager.fetchData("/users"); manager.fetchData("/suspended");
            // break;
            // case "8": manager.removeMenu();break;
            // case "9": manager.borrowBook(); break;
            // case "10": running = false; break;
            // default: break;
            // }

            switch (choice) {
                case "1":
                    manager.fetchData("/books");
                    manager.fetchData("/magazines");
                    manager.fetchData("/users");
                    manager.fetchData("/suspended");
                    break;
                case "2":
                    manager.printAllItems();
                    break;
                case "3":
                    manager.borrowBook();
                    break;
                case "4":
                    String title = IO.readln("Skriv titel på magazin eller bok");
                    manager.searchTitle(title);
                    break;
                case "5":
                    manager.managmentOfItems();
                    break;
                case "6":
                    manager.userManagerMenu();
                    break;
                case "7": 
                    manager.sendToServer();
                    break; 
                case"8": 
                
                case "9": 
                    IO.println("Programet avslutas");
                    running = false; 
                    break;

                default:
                    break;
            }
        }
    }
}