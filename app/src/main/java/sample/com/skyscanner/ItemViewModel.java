package sample.com.skyscanner;


import androidx.databinding.BaseObservable;

import retrofit2.Retrofit;
import sample.com.skyscanner.Network.RetrofitUtil;
import sample.com.skyscanner.Network.WeatherService;

public class ItemViewModel extends BaseObservable {
    Retrofit retrofit = RetrofitUtil.getRetrofitInstance();
    WeatherService weatherService = retrofit.create(WeatherService.class);

    public ItemViewModel() {
//        Call<sample.com.skyscanner.Objects.Model> call = weatherService.getWeather();
//        call.enqueue(new Callback<sample.com.skyscanner.Objects.Model>() {
//
//            @Override
//            public void onResponse(Call<sample.com.skyscanner.Objects.Model> call, Response<sample.com.skyscanner.Objects.Model> response) {
//                if (response.body() != null) {
//                }
//            }
//
//            @Override
//            public void onFailure(Call<sample.com.skyscanner.Objects.Model> call, Throwable t) {
//            }
//        });
    }
}
