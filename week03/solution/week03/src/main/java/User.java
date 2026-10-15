// A person who uses the Book Review Platform.
public class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        setEmail(email);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    // Accepts only text that contains the character @. Anything else is ignored.
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }


    @Override
    public String toString() {
        return username + " (" + email + ")";
    }
}
