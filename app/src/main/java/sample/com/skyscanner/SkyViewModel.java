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
        itemViewModels.add(new ItemViewModel("Chennai,in"));
        itemViewModels.add(new ItemViewModel("Varanasi,in"));
        itemViewModels.add(new ItemViewModel("Delhi,in"));
        itemViewModels.add(new ItemViewModel("Bengaluru,in"));
        itemViewModels.add(new ItemViewModel("Mumbai,in"));
        itemViewModels.add(new ItemViewModel("London,uk"));
        itemViewModels.add(new ItemViewModel("Sydney,au"));

        recyclerAdapter = new RecyclerAdapter(itemViewModels);
    }

    public RecyclerAdapter getAdapter() {
        return recyclerAdapter;
    }
}