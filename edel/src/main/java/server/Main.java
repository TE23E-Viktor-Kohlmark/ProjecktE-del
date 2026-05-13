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
                    1. Hämta alla böker
                    2. Hämta alla tining
                    3. Skriv ut hämtad data
                    4. Lägg till en bok/tidning
                        """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": manager.fetchData("/books");break;
                case "2": manager.fetchData("/magazines");break;
                case "3": manager.printAllItems();break;
                case "4": manager.addItem(); break;
                case "5": running = false; break;
                default: break;
            }
        }
    }
}
    