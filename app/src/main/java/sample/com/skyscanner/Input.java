package sample.com.skyscanner;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LifecycleObserver;

import java.io.Serializable;

import javax.inject.Inject;

public class Input extends BaseObservable implements LifecycleObserver, Serializable {

    String origin;
    String dest;
    String outDate;
    String currency;

    @Inject
    public Input() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
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
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
