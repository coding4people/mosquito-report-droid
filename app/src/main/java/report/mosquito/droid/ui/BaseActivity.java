package report.mosquito.droid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import report.mosquito.droid.MosquitoApp;
import report.mosquito.droid.di.components.AppComponent;

/**
 * Created by adriano on 23/02/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected  abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    protected AppComponent getAppComponent() {
        return ((MosquitoApp) getApplication()).getAppComponent();
    }
}
