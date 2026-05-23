package server;

public class SuspendedUser {
    protected String id;
protected String userID; 
protected String reason; 

SuspendedUser(String id, String userID ) {
    this.id = id; 
    this.userID = userID; 
}


public String getId() {
    return id;
}
public String getUserID() {
    return userID;
}
@Override 
public String toString() {
    return String.format("[AVSTÄNGD] Spärr-ID: %s | Användar-ID: %s", 
                             id, userID); 
}

// public String toString() {
//         return String.format("[User] Name: %s | Id: %s | Email: %s ", 
//                              name, id, email);
//     }


}
