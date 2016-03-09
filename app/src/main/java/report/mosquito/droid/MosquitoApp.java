package report.mosquito.droid;

import android.app.Application;

import report.mosquito.droid.di.components.AppComponent;
import report.mosquito.droid.di.components.DaggerAppComponent;
import report.mosquito.droid.di.modules.AppModule;
import report.mosquito.droid.di.modules.NetworkModule;

/**
 * Created by adriano on 23/02/16.
 */
public class MosquitoApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializerInjector();
    }

    private void initializerInjector() {
        appComponent = DaggerAppComponent .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
