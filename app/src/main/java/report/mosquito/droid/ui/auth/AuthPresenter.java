package report.mosquito.droid.ui.auth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;

import javax.inject.Inject;

import report.mosquito.droid.R;
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

    public void showProgressBar(boolean show, LinearLayout form, android.view.View progressMask) {
        int visibility = show ? android.view.View.VISIBLE : android.view.View.GONE;

        progressMask.setVisibility(visibility);

        int count = form.getChildCount();
        for (int i = 0; i < count; i++) {
            android.view.View view = form.getChildAt(i);
            if (view instanceof TextInputLayout) {
                ((TextInputLayout) view).getEditText().setEnabled(!show);
            }

            view.setEnabled(!show);
        }
    }

    public void showErrorMessage(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.error_title);
        builder.setMessage(R.string.network_error_message);
        builder.setPositiveButton(R.string.ok, null);
        builder.show();
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

    public interface View extends NetworkView {
        void authCallback(User user);
    }
}
