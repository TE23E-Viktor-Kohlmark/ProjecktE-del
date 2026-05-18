//  Viktor Köhlmark 
// Hämtar information från tidning 
package server;

public class Magazine extends LibraryItem {

    private String issueNumber; 
    private String category; 
    private String publishedYear; 

    public Magazine( String id, String title, String issueNumber, String category, String publishedYear, boolean isAvailable) {
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
        this.category = category; 
        this.publishedYear = publishedYear;
    }

    public String toString() {
        return String.format("[Tidning] ID: %s | Titel: %s | IssueNumber: %s | category %s |publishedYear: %s | Tillgänglig: %b", 
                             id, title, issueNumber, category, publishedYear, isAvailable);
    
                        }
}
