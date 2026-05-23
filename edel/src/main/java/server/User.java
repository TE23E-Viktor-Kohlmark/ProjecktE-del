package server;

public class User implements Comparable<User> {
protected String name;  
protected String id ;
protected String email;

public User (String name, String id, String email) {
this.name = name;
this.id = id; 
this.email = email; 
}

public String getEmail() {
    return email;
}
public String getName() {
    return name;
}
public String getId() {
    return id;
}


public String toString() {
        return String.format("[User] Name: %s | Id: %s | Email: %s ", 
                             name, id, email);
    }

    @Override
    public int compareTo(User other) {
        return this.name.compareToIgnoreCase(other.getName());
    }
}

