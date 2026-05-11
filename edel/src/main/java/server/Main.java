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

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

ServerData server = new ServerData(0, null, null, null, 0, false)

        String baseURL = "http://10.151.168.5:3149/"; 
        Gson gson = new Gson(); 

        IO.println("Startar JSON kilent");
        
        System.out.println("Skriv ut alla böcker");
        HttpResponse<String> get_all_bosks;
        try {
            int status = get_all_bosks.getStatus()
            if(status != 200) {
                IO.println("Fel på servern");
            }

            String get_all_body = get_all_bosks.getTitle();

            
        } catch (Exception e) {
            IO.println("Error" + e);
        return;
        }
    }

    // Retrive all the books 

}