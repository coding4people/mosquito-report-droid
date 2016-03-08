package report.mosquito.droid.ui.signup;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import report.mosquito.droid.R;
import report.mosquito.droid.models.User;
import report.mosquito.droid.ui.BaseActivity;

/**
 * Created by adriano on 23/02/16.
 */
public class SignUpActivity extends BaseActivity implements SignUpPresenter.View {

    @Inject SignUpPresenter presenter;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.sign_up_email) TextInputLayout email;
    @Bind(R.id.sign_up_first_name) TextInputLayout firstName;
    @Bind(R.id.sign_up_last_name) TextInputLayout lastName;
    @Bind(R.id.sign_up_password) TextInputLayout password;
    @Bind(R.id.sign_up_confirm_password) TextInputLayout confirmPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.sign_up_activitiy;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        super.getAppComponent().inject(this);

        setSupportActionBar(toolbar);

        presenter.setView(this);
    }

    @OnClick(R.id.sign_up_action)
    public void doSignUp() {


        if (!validate()) {
            return;
        }

        User user = new User(firstName.getEditText().getText().toString(),
                lastName.getEditText().getText().toString(),
                email.getEditText().getText().toString(),
                password.getEditText().getText().toString());

        presenter.doSignUp(user);
    }

    private boolean validate() {
        boolean isValid = true;

        if (email.getEditText().getText().toString().isEmpty()) {
            email.setError(getString(R.string.form_invalid_email_empty));
            isValid = false;
        } else {
            email.setErrorEnabled(false);
        }

        if (firstName.getEditText().getText().toString().isEmpty()) {
            firstName.setError(getString(R.string.form_invalid_first_name_empty));
            isValid = false;
        } else {
            firstName.setErrorEnabled(false);
        }

        if (lastName.getEditText().getText().toString().isEmpty()) {
            lastName.setError(getString(R.string.form_invalid_last_name_empty));
            isValid = false;
        } else {
            lastName.setErrorEnabled(false);
        }

        if (password.getEditText().getText().toString().isEmpty()) {
            password.setError(getString(R.string.form_invalid_password_empty));
            isValid = false;
        } else {
            password.setErrorEnabled(false);
        }

        return isValid;
    }

    @Override
    public void signUpCallback(User user) {

    }

    @Override
    public void showLoading(boolean show) {
        Toast.makeText(this, "Show Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestError() {

    }
}
