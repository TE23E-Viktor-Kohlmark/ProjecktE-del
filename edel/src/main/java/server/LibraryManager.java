// Viktor köhlmark 
// Är classen som hanterar alla andra klasser 

package server;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<LibraryItem> items;

    public LibraryManager() {
        this.items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void printAllItems() {
        if(items.isEmpty()) {
            IO.println("Listan är tom");

        } else {
            for(LibraryItem item : items) {
                IO.println(item.toString());
            }
        }
    }

}
