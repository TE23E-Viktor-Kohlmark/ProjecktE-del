// Viktor köhlmark 
// Är classen som hanterar alla andra klasser 

package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.protocol.HTTP;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

public class LibraryManager {

    private List<Book> books = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<SuspendedUser> suspednUsers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void printBooks() {
        IO.println("\n--- BÖCKER ---");
        if (books.isEmpty())
            System.out.println("Inga böcker sparade.");
        else {
            Collections.sort(books);
            for (Book b : books)
                System.out.println(b.toString());
        }
    }

    public void printMagazines() {
        System.out.println("\n--- TIDNINGAR ---");
        if (magazines.isEmpty())
            System.out.println("Inga tidningar sparade.");
        else {

            Collections.sort(magazines);
            for (Magazine m : magazines)
                System.out.println(m.toString());
        }
    }

    public void printUsers() {
        System.out.println("\n--- Users ---");
        if (users.isEmpty())
            System.out.println("Inga användare sparade.");
        else {

            Collections.sort(users);
            for (User m : users)
                System.out.println(m.toString());
        }
    }

    public void printsuspendenUSers() {
        System.out.println("\n--- Suspendedusrs ---");
        if (suspednUsers.isEmpty())
            System.out.println("Inga användare sparade.");
        for (SuspendedUser m : suspednUsers)
            System.out.println(m.toString());
    }

    public void printAllItems() {
        printBooks();
        printMagazines();
        printUsers();
        printsuspendenUSers();
    }

    public static String baseURL = "http://localhost:3000";

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
                } else if (urlEnd.contains("users")) {
                    String responseBody = response.getBody();
                    List<User> fetched = gson.fromJson(responseBody, new TypeToken<List<User>>() {
                    }.getType());
                    users.addAll(fetched);
                } else if (urlEnd.contains("suspended")) {
                    String responseBody = response.getBody();
                    List<SuspendedUser> fetched = gson.fromJson(responseBody, new TypeToken<List<SuspendedUser>>() {
                    }.getType());
                    suspednUsers.addAll(fetched);

                }
                IO.println("Datan sparad");
            } else {
                IO.println("Kunde int hämta data " + response.getStatus());
            }
        } catch (

        UnirestException e) {
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

                try {
                    Gson gson = new Gson();
                    String jsonBook = gson.toJson(book);

                    HttpResponse<String> response = Unirest.post(baseURL + "/books")
                            .header("Content-Type", "application/json")
                            .body(jsonBook)
                            .asString();

                    if (response.getStatus() == 200) {
                        IO.println("Boken har sparats till servern");
                    } else {
                        IO.println("Servern tog inte emot boken " + response.getStatus());
                    }
                } catch (Exception e) {
                    IO.println("Kunde inte ta kontakt med servern " + e.getMessage());
                }

                break;

            case "2":
                IO.println("Lägger till ett magazine");
                id = String.valueOf(magazines.size() + 1);
                title = IO.readln("Skriv titel på magazine: ");
                String issueNumber = IO.readln("Skriv issueNumber på magazine: ");
                String category = IO.readln("Skriv kategorin på magazine: ");
                genere = IO.readln("Skriv gener på magazine: ");
                String publishedYear = IO.readln("Skriv när den blev publiserad på boken: ");

                Magazine magazine = new Magazine(id, title, issueNumber, category, publishedYear, true);
try {
                    Gson gson = new Gson();
                    String jsonMagazine = gson.toJson(magazine);

                    HttpResponse<String> response = Unirest.post(baseURL + "/magazine")
                            .header("Content-Type", "application/json")
                            .body(jsonMagazine)
                            .asString();

                    if (response.getStatus() == 200) {
                        IO.println("Tidningen har sparats till servern");
                    } else {
                        IO.println("Servern tog inte emot tidningen " + response.getStatus());
                    }
                } catch (Exception e) {
                    IO.println("Kunde inte ta kontakt med servern " + e.getMessage());
                }
                break;

            default:
                break;
        }
    }

    public void sendToServer() {
        // Listor av magazin och böker
        // Lägg till de som sakans(det nya bökerna)
        // Ge användaren en bekräftelse
        Gson gson = new Gson();
        try {
            String booksJson = gson.toJson(books);
            String magazinesJson = gson.toJson(magazines);

            HttpResponse<String> bookResponse = Unirest.post(baseURL + "/books")
                    .header("placeholder", "application/json")
                    .body(booksJson)
                    .asString();
            HttpResponse<String> magaziResponse = Unirest.post(baseURL + "/magazines")
                    .header("placeholder", "application/json")
                    .body(magazinesJson)
                    .asString();

            if (bookResponse.getStatus() == 200 && magaziResponse.getStatus() == 200) {
                IO.println("Alla data har skickats till servern");
            } else {
                IO.println("Servern to inte emot all data" + bookResponse.getStatus() + magaziResponse.getStatus());
            }

        } catch (Exception e) {
            IO.println("Kunde inte ansluta till servern: " + e.getMessage());
        }
    }

    // Sök funktion till Böker och magazin.
    // Tar in lowercase för att köra genom den lokala listan och sedan
    public void searchTitle(String searchWord) {
        IO.println("Sökresultat för " + searchWord);

        String searchLower = searchWord.toLowerCase();

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(searchLower)) {
                IO.println(" " + b.toString());
            }
        }
        for (Magazine m : magazines) {
            if (m.getTitle().toLowerCase().contains(searchLower)) {
                IO.println(" " + m.toString());
            }
        }

    }

    public void searchUser(String searchEmail) {
        IO.println("Sök efter användare ");

        String searchEmailLower = searchEmail.toLowerCase();

        for (User b : users) {
            if (b.getEmail().toLowerCase().contains(searchEmailLower)) {
                IO.println(" " + b.toString());
            }
        }
    }

    // Ta bort en användare eller item
    public void removeMenu() {
        Boolean running = true;
        while (running) {
            IO.println("""
                    1. Ta bort en bok
                    3. Ta bort magazin
                    3. Ta bort en avnändare
                    4. Avsluta
                    """);

            String choise = IO.readln();
            switch (choise) {
                case "1":
                    String id = IO.readln("Skriv id till boken du vill ta bort: ");
                    removeBook(id);
                    break;
                case "2":
                    id = IO.readln("Skriv id till magazin du vill ta bort: ");
                    removeMagazine(id);
                    break;
                case "3":
                    String email = IO.readln("Skriv id till användraen du vill ta bort: ");
                    removeUser(email);
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }
    // Metoden avser att ta dbort böker som finns i servern genom id
    // Först sickas ett delet anrop
    // Kontroll av server svar
    // Bortagning

    public void removeBook(String id) {

        try {
            HttpResponse<String> response = Unirest.delete(baseURL + "/books/" + id).asString();
            if (response.getStatus() == 200 || response.getStatus() == 204) {

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getID().equalsIgnoreCase(id)) {
                        IO.println("Tog bort boken " + books.get(i).getTitle());
                        books.remove(i);
                        return;
                    }
                }
            } else {
                IO.println("Kunde inte ta bort boken " + response.getStatus());
            }
        } catch (Exception e) {
            IO.println("Kunde inte komunicera med servern " + e.getMessage());
        }

    }

    public void removeMagazine(String id) {
        try {
            HttpResponse<String> response = Unirest.delete(baseURL + "/magazines/" + id).asString();
            if (response.getStatus() == 200 || response.getStatus() == 204) {

                for (int i = 0; i < magazines.size(); i++) {
                    if (magazines.get(i).getID().equalsIgnoreCase(id)) {
                        IO.println("Tog bort tidningen " + magazines.get(i).getTitle());
                        magazines.remove(i);
                        return;
                    }
                }
            } else {
                IO.println("Kunde inte ta bort boken " + response.getStatus());
            }
        } catch (Exception e) {
            IO.println("Kunde inte komunicera med servern " + e.getMessage());
        }

    }

    // Sök först i vanliga användare
    public void removeUser(String email) {

        String searchEmailLower = email.toLowerCase();
        for (User b : users) {
            if (b.getEmail().toLowerCase().contains(searchEmailLower)) {
                String id = b.getId();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getId().equalsIgnoreCase(id)) {
                        IO.println("Tog bort användaren: " + users.get(i).getName());
                        users.remove(i);
                        return;
                    }
                }
            }
        }
    }
    public void suspendUser(SuspendedUser sUser) {

        Gson gson = new Gson(); 
        String json = gson.toJson(sUser);
        HttpResponse<String> response = Unirest.post(baseURL + "/suspended")
        .header("Content-Type", "application/json")
        .body(json)
        .asString();
        if (response.getStatus() == 200) {
            suspednUsers.add(sUser);
        }else {
            IO.println("Servern nekade " + response.getStatus());
        }
    }

}
