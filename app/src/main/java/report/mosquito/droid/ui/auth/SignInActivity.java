package report.mosquito.droid.ui.auth;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import report.mosquito.droid.R;
import report.mosquito.droid.di.components.AuthComponent;
import report.mosquito.droid.di.components.DaggerAuthComponent;
import report.mosquito.droid.models.User;
import report.mosquito.droid.ui.BaseActivity;

/**
 * Created by adriano on 09/03/16.
 */
public class SignInActivity extends BaseActivity implements AuthPresenter.View {

    @Inject AuthPresenter presenter;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.sign_in_form) LinearLayout form;
    @Bind(R.id.sign_in_email) TextInputLayout email;
    @Bind(R.id.sign_in_password) TextInputLayout password;
    @Bind(R.id.progressMask) View progressMask;

    @Override
    protected int getLayoutId() {
        return R.layout.sign_in_activity;
    }

    @Override
    protected void initializeInjector() {
        AuthComponent authComponent = DaggerAuthComponent.builder()
                .networkModule(getNetworkModule())
                .build();

        authComponent.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        presenter.setView(this);
    }

    @OnClick(R.id.sign_in_action)
    public void doSignIn() {
        presenter.doSignIn(email.getEditText().getText().toString(), password.getEditText().getText().toString());
    }

    @Override
    public void authCallback(User user) {

    }

    @Override
    public void showLoading(boolean show) {
        presenter.showProgressBar(show, form, progressMask);
    }

    @Override
    public void onRequestError() {
        presenter.showErrorMessage(this);
    }
}
