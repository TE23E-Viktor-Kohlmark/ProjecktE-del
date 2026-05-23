package server;

public class SuspendedUser {
protected String userID; 
protected String reson; 

SuspendedUser(String userID, String reson ) {
    this.userID = userID; 
    this.reson = reson;
}

public String getReson() {
    return reson;
}

// public String toString() {
//         return String.format("[User] Name: %s | Id: %s | Email: %s ", 
//                              name, id, email);
//     }


}
