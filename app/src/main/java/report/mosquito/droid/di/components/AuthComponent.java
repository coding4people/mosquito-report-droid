package report.mosquito.droid.di.components;

import javax.inject.Singleton;

import dagger.Component;
import report.mosquito.droid.di.modules.NetworkModule;
import report.mosquito.droid.ui.auth.SignInActivity;
import report.mosquito.droid.ui.auth.SignUpActivity;

/**
 * Created by adriano on 09/03/16.
 */
@Singleton
@Component(modules = NetworkModule.class)
public interface AuthComponent {
    void inject(SignUpActivity activity);
    void inject(SignInActivity activity);
}
