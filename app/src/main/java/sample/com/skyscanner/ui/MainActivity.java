package sample.com.skyscanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import sample.com.skyscanner.Input;
import sample.com.skyscanner.R;
import sample.com.skyscanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    TextView textView;

    @Inject
    Input input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setViewModel(input);
        textView = findViewById(R.id.dateText);
        input.setDate(textView.toString());
    }

    public void onClickScan(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("input", input);

        startActivity(intent);
    }
}
