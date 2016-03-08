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
        view.showLoading(true);

        Call<User> call = service.signUp(user);
        call.enqueue(new RequestCallback<User>() {
            @Override
            public void onSuccess(User user) {
                view.signUpCallback(user);
            }

            @Override
            public void onError() {
                view.onRequestError();
            }
        });
    }

    public interface View extends NetworkView {
        void signUpCallback(User user);
    }
}
