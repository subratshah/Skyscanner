package sample.com.skyscanner;


import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

public class ItemViewModel extends BaseObservable {

    public ObservableField<String> duration = new ObservableField<>();
    public ObservableField<String> cost = new ObservableField<>();
    public ObservableField<Boolean> isDirect = new ObservableField<>();

}
