// Viktor Köhlmark
// Är själva kilenten som användaren kommer styra funktionerna från

package server;

//GSON objekt som vi behöver
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
// Importera Type för att hjälpa json att omvandla data
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

//UniREST objekt som vi behöver
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
// Importera Fil hantering
import java.nio.file.*;
import java.io.IOException;
// ArrayList för att lagra objekt
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String baseURL = "http://10.151.168.5:3149";
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
                3. Spara i en samling
                4. Lägg till en bok/tidning
            """);

            String choice = scanner.nextLine();
            
            switch (choice) {
            case "1": fetchData("/books"); break;
            case "2": fetchData("/magazines"); break; 
            case "3": manager.printAllItems(); break; 
            case "4": running = false; break; 
            
            default:
                break;
        }
    }
}
    
    private static void fetchData(String urlEnd) {
        try {
            HttpResponse<String> response = Unirest.get(baseURL + urlEnd).asString();
            
            if(response.getStatus()== 200) {
                IO.println("Information hämtas");
                String jsonResponse = response.getBody(); 
                
                Gson gson = new Gson(); 
                
                if (urlEnd.contains("books")) {
                    Book[] books = gson.fromJson(jsonResponse, Book[].class);
                    for (Book b : books) {
                        manager.addItem(b);
                }
            }
            else if (urlEnd.contains("magazines")) {
                Magazine[] magazines = gson.fromJson(jsonResponse, Magazine[].class);
                for (Magazine b : magazines) {
                    manager.addItem(b);
                }
            }
            IO.println("Datan sparad");
        }else {
            IO.println("Kunde int hämta data " + response.getStatus());
            }
        }catch (UnirestException e) {
            IO.println("Kunde inte hämta data " + e.getMessage());
        }
    }
    
}