package sample.com.skyscanner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import sample.com.skyscanner.Input;
import sample.com.skyscanner.R;
import sample.com.skyscanner.SkyViewModel;
import sample.com.skyscanner.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity implements LifecycleOwner {

    @Inject
    SkyViewModel skyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivitySecondBinding activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);

//        skyViewModel.setInput((Input) getIntent().getSerializableExtra("input"));
        Input input = new Input();
        input.setOutDate(getIntent().getStringExtra("date"));
        input.setOrigin(getIntent().getStringExtra("origin"));
        input.setDest(getIntent().getStringExtra("dest"));
        input.setCurrency(getIntent().getStringExtra("curr"));

        skyViewModel.setInput(input);
        activitySecondBinding.setViewModel(skyViewModel);

        this.getLifecycle().addObserver(skyViewModel);
    }
}
