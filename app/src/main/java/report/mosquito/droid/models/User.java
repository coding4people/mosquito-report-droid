package report.mosquito.droid.models;

/**
 * Created by adriano on 23/02/16.
 */
public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public  User() {

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
