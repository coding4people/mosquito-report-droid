package report.mosquito.droid.ui.signup;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import report.mosquito.droid.models.User;
import report.mosquito.droid.services.AuthService;
import report.mosquito.droid.services.RequestCallback;
import report.mosquito.droid.ui.NetworkView;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by adriano on 23/02/16.
 */
public class AuthPresenter {

    private final AuthService service;
    private AuthPresenter.View view;

    @Inject
    public AuthPresenter(Retrofit retrofit) {
        service = retrofit.create(AuthService.class);
    }

    public void setView(@NonNull AuthPresenter.View view) {
        this.view = view;
    }

    public void doSignUp(@NonNull User user) {
        view.showLoading(true);

        Call<User> call = service.signUp(user);
        call.enqueue(new AuthRequestCallback());
    }

    public void doSignIn(@NonNull String email, @NonNull String password) {
        view.showLoading(true);

        Call<User> call = service.signIn(new User(email, password));
        call.enqueue(new AuthRequestCallback());
    }

    public interface View extends NetworkView {
        void authCallback(User user);
    }

    private class AuthRequestCallback extends RequestCallback<User> {

        @Override
        public void onSuccess(User user) {
            view.authCallback(user);
            view.showLoading(false);
        }

        @Override
        public void onError() {
            view.onRequestError();
            view.showLoading(false);
        }
    }
}
