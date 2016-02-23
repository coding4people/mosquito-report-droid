package report.mosquito.droid.di.components;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Component;
import report.mosquito.droid.di.modules.AppModule;
import report.mosquito.droid.ui.BaseActivity;

/**
 * Created by adriano on 23/02/16.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity activity);

    Context context();
}
