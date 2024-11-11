package com.example.pr8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pr8_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String name = "???";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void saveName(View view) {
        name = binding.nameBox.getText().toString();
    }
    public void getName(View view) {
        binding.nameView.setText(name);
    }

    final static String strVariableKey = "STRING_VARIABLE";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(strVariableKey, name);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(strVariableKey);
        binding.nameView.setText(name);
    }
}