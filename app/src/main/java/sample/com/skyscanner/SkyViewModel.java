package sample.com.skyscanner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import sample.com.skyscanner.model.BaseModel;
import sample.com.skyscanner.network.ScannerServiceManager;

public class SkyViewModel extends ViewModel implements LifecycleObserver {

    MainData mainData;

    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    ScannerServiceManager scannerServiceManager;
    private RecyclerAdapter recyclerAdapter;

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

    public MainData getMainData() {
        return mainData;
    }

    public void setMainData(MainData mainData) {
        this.mainData = mainData;
    }
}