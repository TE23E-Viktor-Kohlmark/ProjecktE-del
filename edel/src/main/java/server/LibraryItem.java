package server;

public class LibraryItem {
    protected String id; 
    protected String title; 
    protected boolean isAvailable;

    public LibraryItem(String id, String title, boolean isAvailable){
        this.title= title; 
        this.id = id; 
        this.isAvailable = isAvailable; 

    }

    public String getID() {return id; }
    public String getTitle() {return title; }
    public boolean isAvailable() {return isAvailable; }

    
    // To string? 

}
