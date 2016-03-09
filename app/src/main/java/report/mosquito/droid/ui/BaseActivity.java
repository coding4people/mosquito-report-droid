package report.mosquito.droid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import report.mosquito.droid.MosquitoApp;
import report.mosquito.droid.R;
import report.mosquito.droid.di.components.AppComponent;
import report.mosquito.droid.di.modules.NetworkModule;

/**
 * Created by adriano on 23/02/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected  abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initializeInjector();
    }

    protected AppComponent getAppComponent() {
        return ((MosquitoApp) getApplication()).getAppComponent();
    }

    protected NetworkModule getNetworkModule() {
        return new NetworkModule(getString(R.string.api_base_url));
    }

    protected abstract void initializeInjector();
}
