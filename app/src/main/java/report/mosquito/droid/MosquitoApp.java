package report.mosquito.droid;

import android.app.Application;

/**
 * Created by adriano on 23/02/16.
 */
public class MosquitoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializerInjector();
    }

    private void initializerInjector() {

    }
}
