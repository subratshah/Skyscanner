package sample.com.skyscanner.network;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sample.com.skyscanner.model.BaseModel;

public class ScannerServiceManager {

    ScannerService scannerService;

    @Inject
    public ScannerServiceManager(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public Observable<BaseModel> getQuotes(String currency, String origin, String dest, String outDate) {
        return scannerService.getQuotes(currency, origin, dest, outDate).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
