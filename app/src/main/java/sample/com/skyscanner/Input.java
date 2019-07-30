package sample.com.skyscanner;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LifecycleObserver;

import java.io.Serializable;

import javax.inject.Inject;

public class Input extends BaseObservable implements LifecycleObserver, Serializable {

    private String origin;
    private String dest;
    private String outDate;
    private String currency;

    @Inject
    public Input() {
    }

    public String getOrigin() {
        return origin.toUpperCase().trim();
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest.toUpperCase().trim();
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getCurrency() {
        return currency.toUpperCase().trim();
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
