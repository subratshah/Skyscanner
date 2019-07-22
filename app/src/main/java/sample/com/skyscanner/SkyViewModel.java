package sample.com.skyscanner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SkyViewModel extends ViewModel implements LifecycleObserver {

    public List<ItemViewModel> itemViewModels = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void init() {

        recyclerAdapter = new RecyclerAdapter();
    }

    public RecyclerAdapter getAdapter() {
        return recyclerAdapter;
    }
}