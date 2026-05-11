// Viktor Köhlmark
// Är själva kilenten som användaren kommer styra funktionerna från

package server;

//GSON objekt som vi behöver
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
// Importera Type för att hjälpa json att omvandla data
import java.lang.reflect.Type;
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
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String baseURL = "http://10.151.168.5:3149" ;
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        IO.println("Hej");

        IO.println(""" 
            Meny 
            1. Hämta alla böker 
            2. Hämta alla tining 
            3. Spara i en samling 
            4. Lägg till en bok/tidning 
                """);


    }

    

}