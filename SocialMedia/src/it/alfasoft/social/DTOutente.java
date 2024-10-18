package it.alfasoft.social;

public class DTOutente {
    private String user;
    private String email;
    private String password;

    public DTOutente(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public DTOutente() {

    }

    @Override
    public String toString() {
        return "DTOutente{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
