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

import sample.com.skyscanner.viewmodels.MainViewModel;
import sample.com.skyscanner.R;
import sample.com.skyscanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, AdapterView.OnItemSelectedListener {

    @Inject
    MainViewModel mainViewModel;

    Spinner spinner;
    Intent intent;
    String[] currencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setTitle("Enter Flight Dertails");
        intent = new Intent(this, SecondActivity.class);
        spinner = findViewById(R.id.currSpinner);
        currencies = new String[]{"INR", "USD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        activityMainBinding.setViewModel(mainViewModel);
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
        intent.putExtra("curr", currencies[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }
}
