package report.mosquito.droid.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import report.mosquito.droid.di.modules.AppModule;

/**
 * Created by adriano on 23/02/16.
 */
@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {
    Context context();
}
