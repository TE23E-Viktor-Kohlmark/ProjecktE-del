package server;

public class SuspendedUser {
    protected String id;
protected String userID; 
protected String reason; 

SuspendedUser(String id, String userID, String reson ) {
    this.id = id; 
    this.userID = userID; 
    this.reason = reson;
}

public String getReson() {
    return reason;
}
public String getId() {
    return id;
}
public String getReason() {
    return reason;
}

@Override 
public String toString() {
    return String.format("[AVSTÄNGD] Spärr-ID: %s | Användar-ID: %s | Orsak: %s", 
                             id, userID, reason); 
}

// public String toString() {
//         return String.format("[User] Name: %s | Id: %s | Email: %s ", 
//                              name, id, email);
//     }


}
