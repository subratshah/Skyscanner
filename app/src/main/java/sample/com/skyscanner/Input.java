package sample.com.skyscanner;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LifecycleObserver;

import java.io.Serializable;

import javax.inject.Inject;

public class Input extends BaseObservable implements LifecycleObserver, Serializable {

    String origin;
    String dest;
    String date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
