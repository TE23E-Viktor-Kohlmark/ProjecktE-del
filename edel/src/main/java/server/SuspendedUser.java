package server;

public class SuspendedUser {
    protected String id;
protected String userId; 
protected String reason; 

    public SuspendedUser(String id, String userId, String reason) {
        this.id = id; 
        this.userId = userId; 
        this.reason = reason;
    }

public String getId() {
    return id;
}
public String getUserId() {
    return userId;
}
    public String getReason() {
        return reason;
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
