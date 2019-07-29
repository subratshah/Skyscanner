package sample.com.skyscanner;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.annotations.NonNull;
import sample.com.skyscanner.databinding.RecyclerviewItemBinding;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Output> outputs;

    RecyclerAdapter(List<Output> outputs) {
        this.outputs = outputs;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        RecyclerviewItemBinding recyclerviewItemBinding = RecyclerviewItemBinding.inflate(layoutInflater, viewGroup, false);
        return new ViewHolder(recyclerviewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        Output output = outputs.get(i);
        viewHolder.bind(output);
    }

    @Override
    public int getItemCount() {
        return outputs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewItemBinding recyclerviewItemBinding;

        public ViewHolder(@NonNull RecyclerviewItemBinding recyclerviewItemBinding) {
            super(recyclerviewItemBinding.getRoot());
            this.recyclerviewItemBinding = recyclerviewItemBinding;
        }

        public void bind(Output output) {
            recyclerviewItemBinding.setViewModel(output);
        }
    }
}