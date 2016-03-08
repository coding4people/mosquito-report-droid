package report.mosquito.droid.services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adriano on 08/03/16.
 */
public abstract class RequestCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccess()) {
            this.onSuccess(response.body());
        } else {
            this.onError();
            response.errorBody();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        this.onError();
    }

    public abstract void onSuccess(T object);
    public abstract void onError();
}
