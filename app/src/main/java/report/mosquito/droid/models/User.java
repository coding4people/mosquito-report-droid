package report.mosquito.droid.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adriano on 23/02/16.
 */
public class User {
    @SerializedName("lastname")
    public String firstName;

    @SerializedName("firstname")
    public String lastName;

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public  User() { }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
