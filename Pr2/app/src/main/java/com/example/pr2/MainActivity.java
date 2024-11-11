package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pr2.R;
import com.example.pr2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnOk;
    private Button btnCancel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Нажми любую кнопку!");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOk) {
            textView.setText("Ok! Нажми Cancel");
            btnOk.setEnabled(false);
            btnCancel.setEnabled(true);
        } else if (v.getId() == R.id.btnCancel) {
            textView.setText("Cancel! Нажми Ok");
            btnOk.setEnabled(true);
            btnCancel.setEnabled(false);
        }
    }
}