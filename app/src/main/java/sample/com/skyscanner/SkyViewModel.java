package sample.com.skyscanner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import sample.com.skyscanner.model.BaseModel;
import sample.com.skyscanner.network.ScannerServiceManager;

public class SkyViewModel extends ViewModel implements LifecycleObserver {

    Input input;

    ScannerServiceManager scannerServiceManager;
    private RecyclerAdapter recyclerAdapter;

    public SkyViewModel(Input input) {
        this.input = input;
    }

    public SkyViewModel(ScannerServiceManager scannerServiceManager) {
        this.scannerServiceManager = scannerServiceManager;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void init() {

        recyclerAdapter = new RecyclerAdapter();
    }

    public RecyclerAdapter getAdapter() {
        return recyclerAdapter;
    }

    public void getQuotes() {
//        scannerServiceManager.getQuotes().subscribe(this::onSuccess, this::onFailure);
    }

    private void onSuccess(BaseModel baseModel) {
    }

    private void onFailure(Throwable throwable) {
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }
}