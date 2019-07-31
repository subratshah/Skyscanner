package sample.com.skyscanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import sample.com.skyscanner.Input;
import sample.com.skyscanner.R;
import sample.com.skyscanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, AdapterView.OnItemSelectedListener {

    @Inject
    Input input;

    Spinner spinner;
    Intent intent;
    String[] currs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        intent = new Intent(this, SecondActivity.class);
        spinner = findViewById(R.id.currSpinner);
        currs = new String[]{"INR", "USD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currs);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        activityMainBinding.setViewModel(input);
    }

    public void onClickScan(View view) {
        TextView textView;
        String text;

        textView = findViewById(R.id.dateText);
        text = String.valueOf(textView.getText());
        intent.putExtra("date", text);

        textView = findViewById(R.id.originText);
        text = String.valueOf(textView.getText());
        intent.putExtra("origin", text);

        textView = findViewById(R.id.destText);
        text = String.valueOf(textView.getText());
        intent.putExtra("dest", text);

        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        intent.putExtra("curr", currs[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }
}
