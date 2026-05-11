//  Viktor Köhlmark 
// Hämtar information från tidning 
package server;

public class Magazine extends LibraryItem {

    private int issueNumber; 
    private String category; 
    private int publishYear; 

    public Magazine( String id, String title, int issueNumber, String category, int publishYear, boolean isAvailable) {
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
        this.category = category; 
        this.publishYear = publishYear;
    }
//  TODO: to string 
}
