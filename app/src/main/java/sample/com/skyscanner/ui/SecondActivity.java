package sample.com.skyscanner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import sample.com.skyscanner.R;
import sample.com.skyscanner.databinding.ActivitySecondBinding;
import sample.com.skyscanner.viewmodels.MainViewModel;
import sample.com.skyscanner.viewmodels.SecondViewModel;

public class SecondActivity extends AppCompatActivity implements LifecycleOwner {

    @Inject
    SecondViewModel secondViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivitySecondBinding activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        MainViewModel mainViewModel = new MainViewModel();
        mainViewModel.outDate.set(getIntent().getStringExtra("date"));
        mainViewModel.origin.set(getIntent().getStringExtra("origin").toUpperCase().trim());
        mainViewModel.dest.set(getIntent().getStringExtra("dest").toUpperCase().trim());
        mainViewModel.currency.set(getIntent().getStringExtra("curr"));

        setTitle("Flights from " + mainViewModel.origin.get() + " to " + mainViewModel.dest.get());
        secondViewModel.setMainViewModel(mainViewModel);
        activitySecondBinding.setViewModel(secondViewModel);

        this.getLifecycle().addObserver(secondViewModel);
    }
}
