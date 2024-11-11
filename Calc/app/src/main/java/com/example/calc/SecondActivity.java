package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.calc.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";
    private ActivitySecondBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "SecondActivity: onStart");
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Bundle arguments = getIntent().getExtras();
        binding.textView.setText(arguments.get("Result").toString());
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}