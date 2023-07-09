package studio.angzai.a10119123_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText meterEditText;
    private EditText kilometerEditText;
    private EditText centimeterEditText;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        initView();
        observeViewModel();
    }

    private void initView() {
        meterEditText = findViewById(R.id.meter);
        kilometerEditText = findViewById(R.id.kilometer);
        centimeterEditText = findViewById(R.id.centimeter);

        meterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.calculateLength(editable.toString());
            }
        });
    }

    private void observeViewModel() {
        viewModel.getKilometer().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String kilometer) {
                kilometerEditText.setText(kilometer);
            }
        });

        viewModel.getCentimeter().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String centimeter) {
                centimeterEditText.setText(centimeter);
            }
        });
    }

    public String getMeter() {
        return meterEditText.getText().toString();
    }
}