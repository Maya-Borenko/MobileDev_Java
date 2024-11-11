package com.example.pr6_1_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.pr6_1_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    boolean isHide = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHide){
                    getSupportActionBar().show();
                    isHide = false;
                    binding.hide.setText("Hide");
                }
                else{
                    getSupportActionBar().hide();
                    isHide = true;
                    binding.hide.setText("Show");
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Боренко Майя");
        actionbar.setSubtitle("ИКБО-03-22");
        return true;
    }
}