package sample.com.skyscanner.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleObserver;

import java.io.Serializable;

import javax.inject.Inject;

public class MainViewModel extends BaseObservable implements LifecycleObserver, Serializable {

    public ObservableField<String> origin = new ObservableField<>();
    public ObservableField<String> dest = new ObservableField<>();
    public ObservableField<String> outDate = new ObservableField<>();
    public ObservableField<String> currency = new ObservableField<>();

    @Inject
    public MainViewModel() {
    }
}
