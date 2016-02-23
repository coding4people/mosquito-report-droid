package report.mosquito.droid.ui.signup;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Named;

import report.mosquito.droid.models.User;
import report.mosquito.droid.ui.NetworkView;
import retrofit2.Retrofit;

/**
 * Created by adriano on 23/02/16.
 */
public class SignUpPresenter {

    private Retrofit retrofit;
    private SignUpPresenter.View view;

    @Inject
    public SignUpPresenter(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void setView(@NonNull SignUpPresenter.View view) {
        this.view = view;
    }

    public void doSignup(@NonNull User user) {
        view.showLoading();
        view.hideLoading();
        view.signupCallback();
    }

    public interface View extends NetworkView {
        void signupCallback ();
    }
}
