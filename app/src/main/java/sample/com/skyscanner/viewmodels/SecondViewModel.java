package sample.com.skyscanner.viewmodels;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import sample.com.skyscanner.RecyclerAdapter;
import sample.com.skyscanner.model.BaseModel;
import sample.com.skyscanner.model.Carrier;
import sample.com.skyscanner.model.Quote;
import sample.com.skyscanner.network.ScannerServiceManager;

import static android.content.ContentValues.TAG;

public class SecondViewModel extends ViewModel implements LifecycleObserver {

    public MainViewModel mainViewModel;
    public RecyclerAdapter adapter;

    private ScannerServiceManager scannerServiceManager;
    private List<FlightItemViewModel> flightItemViewModels = new ArrayList<>();
    private int directOrder = -1;
    private int priceOrder = -1;
    private int timeOrder = -1;

    @Inject
    public SecondViewModel(ScannerServiceManager scannerServiceManager) {
        this.scannerServiceManager = scannerServiceManager;
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        adapter = new RecyclerAdapter(flightItemViewModels);
        scannerServiceManager.getRuotes(mainViewModel.currency.get(), mainViewModel.origin.get(), mainViewModel.dest.get(), mainViewModel.outDate.get()).subscribe(this::onNext, this::onError);
    }

    private void onError(Throwable throwable) {
        Log.e(TAG, "onError: " + Arrays.toString(throwable.getStackTrace()));
    }

    private void onNext(BaseModel baseModel) {

        for (Quote quote : baseModel.getQuotes()) {
            FlightItemViewModel flightItemViewModel = new FlightItemViewModel();
            for (Carrier carrier : baseModel.getCarriers()) {
                if (String.valueOf(carrier.getCarrierId()).equals(quote.getOutboundLeg().getCarrierIds().get(0)))
                    flightItemViewModel.setAirline(carrier.getName());
            }
            flightItemViewModel.setDate(quote.getOutboundLeg().getDepartureDate().substring(0, 10));
            flightItemViewModel.setTime(quote.getQuoteDateTime().substring(11));
            flightItemViewModel.setDirect(quote.getDirect() ? "Direct" : "Indirect");
            flightItemViewModel.setPrice(baseModel.getCurrencies().get(0).getSymbol() + quote.getMinPrice());
            flightItemViewModels.add(flightItemViewModel);
        }
        adapter.notifyDataSetChanged();
    }

    public void sortPrice(View view) {
        Collections.sort(flightItemViewModels, FlightItemViewModel.PriceComparator);
        if (priceOrder < 0) {
            priceOrder = 1;
        } else {
            priceOrder = -1;
            Collections.reverse(flightItemViewModels);
        }
        adapter.notifyDataSetChanged();
    }

    public void sortDirect(View view) {
        Collections.sort(flightItemViewModels, FlightItemViewModel.DirectComparator);
        if (directOrder < 0) {
            directOrder = 1;
        } else {
            directOrder = -1;
            Collections.reverse(flightItemViewModels);
        }
        adapter.notifyDataSetChanged();
    }

    public void sortTime(View view) {
        Collections.sort(flightItemViewModels, FlightItemViewModel.TimeComparator);
        if (timeOrder < 0) {
            timeOrder = 1;
        } else {
            timeOrder = -1;
            Collections.reverse(flightItemViewModels);
        }
        adapter.notifyDataSetChanged();
    }

    public void setMainViewModel(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    public RecyclerAdapter getAdapter() {
        return adapter;
    }
}