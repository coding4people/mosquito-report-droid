package report.mosquito.droid.ui.signup;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
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
    @Bind(R.id.sign_up_email) TextView email;
    @Bind(R.id.sign_up_first_name) TextView firstName;
    @Bind(R.id.sign_up_last_name) TextView lastName;
    @Bind(R.id.sign_up_password) TextView password;
    @Bind(R.id.sign_up_cofirm_password) TextView confirmPassword;

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
    public void doSignup() {
        User user = new User(firstName.getText().toString(),
                            lastName.getText().toString(),
                            email.getText().toString(),
                            password.getText().toString());

        presenter.doSignUp(user);
    }

    @Override
    public void signUpCallback(User user) {

    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Show Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "Hide Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestError() {

    }
}
