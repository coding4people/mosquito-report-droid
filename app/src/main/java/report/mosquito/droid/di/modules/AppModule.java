package report.mosquito.droid.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import report.mosquito.droid.MosquitoApp;

/**
 * Created by adriano on 23/02/16.
 */
@Module
public class AppModule {

    private final MosquitoApp application;

    public AppModule (MosquitoApp application) { this.application = application; }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}
