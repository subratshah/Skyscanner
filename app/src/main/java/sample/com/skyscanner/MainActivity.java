package sample.com.skyscanner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import sample.com.skyscanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        SkyViewModel skyViewModel = new SkyViewModel();
        this.getLifecycle().addObserver(skyViewModel);
    }
}
