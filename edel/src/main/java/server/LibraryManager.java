// Viktor köhlmark 
// Är classen som hanterar alla andra klasser 

package server;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

public class LibraryManager {

    private List<Book> books = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void printBooks() {
        System.out.println("\n--- BÖCKER ---");
        if (books.isEmpty())
            System.out.println("Inga böcker sparade.");
        for (Book b : books)
            System.out.println(b.toString());
    }

    public void printMagazines() {
        System.out.println("\n--- TIDNINGAR ---");
        if (magazines.isEmpty())
            System.out.println("Inga tidningar sparade.");
        for (Magazine m : magazines)
            System.out.println(m.toString());
    }

    public void printAllItems() {
        printBooks();
        printMagazines();
    }

    public static String baseURL = "http://10.151.168.5:3149";

    public void fetchData(String urlEnd) {
        try {
            HttpResponse<String> response = Unirest.get(baseURL + urlEnd).asString();

            if (response.getStatus() == 200) {
                IO.println("Information hämtas");

                Gson gson = new Gson();

                if (urlEnd.contains("books")) {
                    String responseBody = response.getBody();
                    List<Book> fetched = gson.fromJson(responseBody, new TypeToken<List<Book>>() {
                    }.getType());
                    books.addAll(fetched);

                } else if (urlEnd.contains("magazines")) {
                    String responseBody = response.getBody();
                    List<Magazine> fetched = gson.fromJson(responseBody, new TypeToken<List<Magazine>>() {
                    }.getType());
                    magazines.addAll(fetched);
                }
                IO.println("Datan sparad");
            } else {
                IO.println("Kunde int hämta data " + response.getStatus());
            }
        } catch (UnirestException e) {
            IO.println("Kunde inte hämta data " + e.getMessage());
        }
    }

    public void addItem() {
        IO.println("""
            \n 
                1. Book
                2. Magazine
                3. Avsluta
                """);
        
        String choisce = IO.readln();

        switch (choisce) {
            case "1":
                IO.println("Lägger till en bok");
                String id = String.valueOf(books.size() + 1);
                String title = IO.readln("Skriv titel på boken: ");
                String author = IO.readln("Skriv författare på boken: ");
                String genere = IO.readln("Skriv gener på boken: ");
                String pagesStr = IO.readln("Skriv sidor på boken: ");
                int pages = Integer.parseInt(pagesStr);

                Book book = new Book(id, title, author, genere, pages, true);
                books.add(book);
                break; 

            case "2":
                IO.println("Lägger till ett magazine");
                id = String.valueOf(books.size() + 1);
                title = IO.readln("Skriv titel på magazine: ");
                String issueNumber = IO.readln("Skriv issueNumber på magazine: ");
                String category = IO.readln("Skriv kategorin på magazine: ");
                genere = IO.readln("Skriv gener på magazine: ");
                String publishedYear = IO.readln("Skriv när den blev publiserad på boken: ");

                Magazine magazine = new Magazine(id, title, issueNumber, category, publishedYear, true);
                magazines.add(magazine);
                break; 

            default:
                break;
        }
    }

}
