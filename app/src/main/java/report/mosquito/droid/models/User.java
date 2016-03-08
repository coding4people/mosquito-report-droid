package report.mosquito.droid.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adriano on 23/02/16.
 */
public class User {
    @SerializedName("guid")
    public String guid;

    @SerializedName("firstname")
    public String firstName;

    @SerializedName("lastname")
    public String lastName;

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("location")
    public String location;

    @SerializedName("facebookurl")
    public String facebookurl;

    @SerializedName("twitter")
    public String twitter;

    @SerializedName("profilepictureguid")
    public String profilepictureguid;

    public  User() { }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
