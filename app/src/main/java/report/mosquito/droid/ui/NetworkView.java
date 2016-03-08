package report.mosquito.droid.ui;

/**
 * Created by adriano on 23/02/16.
 */
public interface NetworkView {
    void showLoading();
    void hideLoading();
    void onRequestError();
}
