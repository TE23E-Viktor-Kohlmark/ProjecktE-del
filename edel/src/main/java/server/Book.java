// Viktor Köhlmark
// Hämtar information från bok 

package server;

public class Book extends LibraryItem {
    protected String author; 
    protected String genere; 
    protected int pages; 

    public Book(String id, String title, String author, String genere, int pages, boolean isAvailable) {
        super(id, title, isAvailable); 
       
        this.author = author; 
        this.genere = genere; 
        this.pages = pages; 
 
    }

    public String toString() {
        return String.format("[Bok] ID: %s | Titel: %s | Författare: %s | Sidor: %d | Tillgänglig: %b", 
                             id, title, author, pages, isAvailable);
    }

}
