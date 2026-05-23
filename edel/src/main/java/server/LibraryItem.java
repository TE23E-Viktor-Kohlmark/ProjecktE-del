package server;

public class LibraryItem  implements Comparable<LibraryItem> {
    protected String id; 
    protected String title; 
    protected boolean isAvailable;

    public LibraryItem(String id, String title, boolean isAvailable){
        this.title= title; 
        this.id = id; 
        this.isAvailable = isAvailable; 

    }

    public String getId() {return id; }
    public String getTitle() {return title; }
    public boolean isAvailable() {return isAvailable; }

    @Override 
    public int compareTo(LibraryItem other) {
        return this.title.compareToIgnoreCase(other.getTitle()); 
    }
    

}
