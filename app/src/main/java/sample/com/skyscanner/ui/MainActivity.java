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

//        input = new Input();
//        textView = findViewById(R.id.dateText);
//        input.setOutDate(textView.toString());
//        textView = findViewById(R.id.originText);
//        input.setOrigin(textView.toString());
//        textView = findViewById(R.id.destText);
//        input.setDest(textView.toString());
//        textView = findViewById(R.id.currText);
//        input.setCurrency(textView.toString());

        activityMainBinding.setViewModel(input);

    }

    public void onClickScan(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("input", input);
        intent.putExtra("date", "2019-09-01");
        intent.putExtra("origin", "SFO-sky");
        intent.putExtra("dest", "ORD-sky");
        intent.putExtra("curr", "USD");

        startActivity(intent);
    }
}
