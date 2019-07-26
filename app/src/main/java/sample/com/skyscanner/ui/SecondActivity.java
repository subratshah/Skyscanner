package sample.com.skyscanner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

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
        ActivitySecondBinding activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        Input input = (Input) getIntent().getSerializableExtra("input");
        activitySecondBinding.setViewModel(input);
    }
}
