package report.mosquito.droid.ui.signup;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import report.mosquito.droid.models.User;
import report.mosquito.droid.ui.NetworkView;
import retrofit2.Retrofit;

/**
 * Created by adriano on 23/02/16.
 */
public class SignUpPresenter {

    private final Retrofit retrofit;
    private SignUpPresenter.View view;

    @Inject
    public SignUpPresenter(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void setView(@NonNull SignUpPresenter.View view) {
        this.view = view;
    }

    public void doSignUp(@NonNull User user) {
        view.showLoading();
        view.signUpCallback();
        view.hideLoading();
    }

    public interface View extends NetworkView {
        void signUpCallback();
    }
}
