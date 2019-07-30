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

    @Inject
    Input input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setViewModel(input);
    }

    public void onClickScan(View view) {
        TextView textView;
        String text;
        Intent intent = new Intent(this, SecondActivity.class);

        textView = findViewById(R.id.dateText);
        text = String.valueOf(textView.getText());
        intent.putExtra("date", text);

        textView = findViewById(R.id.originText);
        text = String.valueOf(textView.getText());
        intent.putExtra("origin", text);

        textView = findViewById(R.id.destText);
        text = String.valueOf(textView.getText());
        intent.putExtra("dest", text);

        textView = findViewById(R.id.currText);
        text = String.valueOf(textView.getText());
        intent.putExtra("curr", text);

        startActivity(intent);
    }
}
