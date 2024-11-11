package com.example.pr_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pr_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Button btnOk;
    private Button btnCancel;
    private TextView textView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText("Ok! Нажмите Cancel");
                binding.btnOk.setEnabled(false);
                binding.btnCancel.setEnabled(true);

            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText("Cancel! Нажмите Ok");
                binding.btnOk.setEnabled(true);
                binding.btnCancel.setEnabled(false);
            }
        });
    }
}