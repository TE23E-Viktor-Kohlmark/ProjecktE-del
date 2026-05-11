package server;

public class ServerData {
    private int id;
    private String title;
    private String author;
    private String genre; 
    private int pages; 
    private boolean isAvailable; 

    public ServerData(int id, String title, String author, String genre, int pages, boolean isAvailable) {
    IO.println("Post( MED ID)");
        this.id = id;
        this.title = title;
        this.author  = author;
        this.genre = genre;
        this.pages= pages;
        this.isAvailable = isAvailable; 
    }

    public void setId(int id) {this.id=id;}

    public int getId() {return id;}

    public String getTitle() {return title;}

    public String getAuthor() {return author;}

    public String getGenre() {return genre;}

    public int getPages() {return pages;}

    public boolean getisAvailable() {return isAvailable;}

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Item id=" + id + ", title =" + title + ", author = " + author + ", genre = " + genre + ", pages = " + pages ;
    }

    
}
