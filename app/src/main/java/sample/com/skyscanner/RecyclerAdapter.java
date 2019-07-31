package sample.com.skyscanner;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import sample.com.skyscanner.databinding.ItemRecyclerflightBinding;
import sample.com.skyscanner.viewmodels.FlightItemViewModel;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<FlightItemViewModel> flightItemViewModels;

    public RecyclerAdapter(List<FlightItemViewModel> flightItemViewModels) {
        this.flightItemViewModels = flightItemViewModels;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemRecyclerflightBinding itemRecyclerflightBinding = ItemRecyclerflightBinding.inflate(layoutInflater, viewGroup, false);
        return new ViewHolder(itemRecyclerflightBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        FlightItemViewModel flightItemViewModel = flightItemViewModels.get(i);
        viewHolder.bind(flightItemViewModel);
    }

    @Override
    public int getItemCount() {
        return flightItemViewModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemRecyclerflightBinding itemRecyclerflightBinding;

        public ViewHolder(@NonNull ItemRecyclerflightBinding itemRecyclerflightBinding) {
            super(itemRecyclerflightBinding.getRoot());
            this.itemRecyclerflightBinding = itemRecyclerflightBinding;
        }

        public void bind(FlightItemViewModel flightItemViewModel) {
            itemRecyclerflightBinding.setViewModel(flightItemViewModel);
        }
    }
}