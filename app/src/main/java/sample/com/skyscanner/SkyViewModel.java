package sample.com.skyscanner;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sample.com.skyscanner.model.BaseModel;
import sample.com.skyscanner.model.Carrier;
import sample.com.skyscanner.model.Quote;
import sample.com.skyscanner.network.ScannerServiceManager;

import static android.content.ContentValues.TAG;

public class SkyViewModel extends ViewModel implements LifecycleObserver {

    Input input;
    List<Output> outputs = new ArrayList<>();

    ScannerServiceManager scannerServiceManager;
    public RecyclerAdapter recyclerAdapter;

    @Inject
    public SkyViewModel(ScannerServiceManager scannerServiceManager) {
        this.scannerServiceManager = scannerServiceManager;
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        scannerServiceManager.getQuotes(input.currency, input.origin, input.dest, input.outDate).subscribe(this::onNext, this::onError);

    }

    private void onError(Throwable throwable) {
        Log.e(TAG, "onError: " + throwable.getStackTrace());
    }

    private void onNext(BaseModel baseModel) {

        for (Quote quote : baseModel.getQuotes()) {
            Output output = new Output();
            for (Carrier carrier : baseModel.getCarriers()) {
                if (String.valueOf(carrier.getCarrierId()).equals(quote.getOutboundLeg().getCarrierIds().get(0)))
                    output.setAirline(carrier.getName());
            }
            output.setDate(quote.getQuoteDateTime());
            output.setDirect(quote.getDirect() ? "Direct" : "Indirect");
            output.setPrice(quote.getMinPrice());
            outputs.add(output);
        }

        recyclerAdapter = new RecyclerAdapter(outputs);
    }

    public RecyclerAdapter getRecyclerAdapter() {
        return recyclerAdapter;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }
}