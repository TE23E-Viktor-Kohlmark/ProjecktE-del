import java.util.ArrayList;
import java.util.List;
package server;

public class LibraryManager {

    private List<LibraryItem> items; 

    public LibraryManager() {
        this.items = new ArrayList<>(); 
    }

public void addItem(LibraryItem item) {
        items.add(item);
    }

    
}
