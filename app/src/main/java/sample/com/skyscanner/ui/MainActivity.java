package sample.com.skyscanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import sample.com.skyscanner.MainData;
import sample.com.skyscanner.R;
import sample.com.skyscanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    @Inject
    SkyViewModel skyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setViewModel(mainData);
        textView = findViewById(R.id.dateText);
    }

    public void onClickScan(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("date", mainData.getDate());
        intent.putExtra("bundle", bundle);

        startActivity(intent);
    }
}
