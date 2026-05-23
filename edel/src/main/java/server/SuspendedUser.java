package server;
// Viktor Köhlmark 
// Är klassen som tar hand om de avstänga användarna 
public class SuspendedUser {
    protected String id;
    protected String userId; 

    public SuspendedUser(String id, String userId) {
        this.id = id; 
        this.userId = userId; 
    }

public String getId() {
    return id;
}
public String getUserId() {
    return userId;
}

@Override 
public String toString() {
    return String.format("[AVSTÄNGD] Spärr-ID: %s | Användar-ID: %s", 
                             id, userId); 
}

// public String toString() {
//         return String.format("[User] Name: %s | Id: %s | Email: %s ", 
//                              name, id, email);
//     }


}
