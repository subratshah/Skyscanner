package sample.com.skyscanner;

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

import sample.com.skyscanner.model.BaseModel;
import sample.com.skyscanner.model.Carrier;
import sample.com.skyscanner.model.Quote;
import sample.com.skyscanner.network.ScannerServiceManager;

import static android.content.ContentValues.TAG;

public class SkyViewModel extends ViewModel implements LifecycleObserver {

    Input input;
    private ScannerServiceManager scannerServiceManager;
    private List<Output> outputs = new ArrayList<>();
    public RecyclerAdapter adapter = new RecyclerAdapter(outputs);
    private int directOrder = -1;
    private int priceOrder = -1;
    private int timeOrder = -1;

    @Inject
    public SkyViewModel(ScannerServiceManager scannerServiceManager) {
        this.scannerServiceManager = scannerServiceManager;
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        scannerServiceManager.getRuotes(input.getCurrency(), input.getOrigin(), input.getDest(), input.getOutDate()).subscribe(this::onNext, this::onError);
    }

    private void onError(Throwable throwable) {
        Log.e(TAG, "onError: " + Arrays.toString(throwable.getStackTrace()));
    }

    private void onNext(BaseModel baseModel) {

        for (Quote quote : baseModel.getQuotes()) {
            Output output = new Output();
            for (Carrier carrier : baseModel.getCarriers()) {
                if (String.valueOf(carrier.getCarrierId()).equals(quote.getOutboundLeg().getCarrierIds().get(0)))
                    output.setAirline(carrier.getName());
            }
            output.setDate(quote.getOutboundLeg().getDepartureDate().substring(0, 10));
            output.setTime(quote.getQuoteDateTime().substring(11));
            output.setDirect(quote.getDirect() ? "Direct" : "Indirect");
            output.setPrice(baseModel.getCurrencies().get(0).getSymbol() + quote.getMinPrice());
            outputs.add(output);
        }
        adapter.notifyDataSetChanged();
    }

    public void sortPrice(View view) {
        Collections.sort(outputs, Output.PriceComparator);
        if (priceOrder < 0) {
            priceOrder = 1;
        } else {
            priceOrder = -1;
            Collections.reverse(outputs);
        }
        adapter.notifyDataSetChanged();
    }

    public void sortDirect(View view) {
        Collections.sort(outputs, Output.DirectComparator);
        if (directOrder < 0) {
            directOrder = 1;
        } else {
            directOrder = -1;
            Collections.reverse(outputs);
        }
        adapter.notifyDataSetChanged();
    }

    public void sortTime(View view) {
        Collections.sort(outputs, Output.TimeComparator);
        if (timeOrder < 0) {
            timeOrder = 1;
        } else {
            timeOrder = -1;
            Collections.reverse(outputs);
        }
        adapter.notifyDataSetChanged();
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public RecyclerAdapter getAdapter() {
        return adapter;
    }
}