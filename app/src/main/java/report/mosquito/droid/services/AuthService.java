package report.mosquito.droid.services;

import report.mosquito.droid.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by adriano on 08/03/16.
 */
public interface AuthService {
    @POST("signup/email")
    Call<User> signUp(@Body User user);

    @POST("auth/email")
    Call<User> signIn(@Body User user);
}
