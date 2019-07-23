package sample.com.skyscanner;

import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sample.com.skyscanner.Network.RetrofitUtil;
import sample.com.skyscanner.Network.ScannerService;
import sample.com.skyscanner.Objects.Model;

public class SkyViewModel extends ViewModel implements LifecycleObserver {

    Retrofit retrofit = RetrofitUtil.getRetrofitInstance();
    ScannerService scannerService = retrofit.create(ScannerService.class);
    public List<ItemViewModel> itemViewModels = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;

    public ObservableField<String> country = new ObservableField<>();
    public ObservableField<String> currency = new ObservableField<>();
    public ObservableField<String> locale = new ObservableField<>();
    public ObservableField<String> origin = new ObservableField<>();
    public ObservableField<String> dest = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void init() {

        recyclerAdapter = new RecyclerAdapter();
    }

    public RecyclerAdapter getAdapter() {
        return recyclerAdapter;
    }

    public void getQuotes(String country, String currency, String locale, String origin, String dest, String date) {
        Call<Model> call = scannerService.getQoutes(country, currency, locale, origin, dest, date);
        call.enqueue(new Callback<Model>() {

            @Override
            public void onResponse(Call<sample.com.skyscanner.Objects.Model> call, Response<Model> response) {
                if (response.body() != null) {
                }
            }

            @Override
            public void onFailure(Call<sample.com.skyscanner.Objects.Model> call, Throwable t) {
            }
        });
    }
}