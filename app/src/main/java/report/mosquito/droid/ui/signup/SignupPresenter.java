package report.mosquito.droid.ui.signup;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import report.mosquito.droid.models.User;
import report.mosquito.droid.services.AuthService;
import report.mosquito.droid.ui.NetworkView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by adriano on 23/02/16.
 */
public class SignUpPresenter {

    private final AuthService service;
    private SignUpPresenter.View view;

    @Inject
    public SignUpPresenter(Retrofit retrofit) {
        service = retrofit.create(AuthService.class);
    }

    public void setView(@NonNull SignUpPresenter.View view) {
        this.view = view;
    }

    public void doSignUp(@NonNull User user) {
        view.showLoading();

        Call<User> call = service.signUp(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                view.signUpCallback(response.body());
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.hideLoading();
            }
        });
    }

    public interface View extends NetworkView {
        void signUpCallback(User user);
    }
}
