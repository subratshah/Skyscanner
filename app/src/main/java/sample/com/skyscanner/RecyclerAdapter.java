package sample.com.skyscanner;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.databinding.RecyclerviewItemBinding;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ItemViewModel> itemViewModels;

    RecyclerAdapter(List<ItemViewModel> itemViewModels) {
        this.itemViewModels = itemViewModels;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerviewItemBinding recyclerviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.recyclerview_item, viewGroup, false);
        return new ViewHolder(recyclerviewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        ItemViewModel itemViewModel = itemViewModels.get(i);
        viewHolder.bind(itemViewModel);
    }

    @Override
    public int getItemCount() {
        return itemViewModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewItemBinding recyclerviewItemBinding;

        public ViewHolder(@NonNull RecyclerviewItemBinding recyclerviewItemBinding) {
            super(recyclerviewItemBinding.getRoot());
            this.recyclerviewItemBinding = recyclerviewItemBinding;
        }

        public void bind(ItemViewModel itemViewModel) {
            recyclerviewItemBinding.setItemViewModel(itemViewModel);
        }
    }
}