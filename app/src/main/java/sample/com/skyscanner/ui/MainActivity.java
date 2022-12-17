package sample.com.skyscanner.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import sample.com.skyscanner.R;
import sample.com.skyscanner.databinding.ActivityMainBinding;
import sample.com.skyscanner.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {

    @Inject
    MainViewModel mainViewModel;

    ActivityMainBinding activityMainBinding;
    Intent intent;
    String[] currencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Enter Flight Dertails");
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        intent = new Intent(this, SecondActivity.class);
        currencies = new String[]{"INR", "USD"};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        activityMainBinding.currSpinner.setAdapter(spinnerAdapter);
        activityMainBinding.currSpinner.setOnItemSelectedListener(this);
    }

    public void onClickDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        activityMainBinding.dateText.setText(i + "-" + String.format("%02d", i1) + "-" + String.format("%02d", i2));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        intent.putExtra("curr", currencies[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
}
