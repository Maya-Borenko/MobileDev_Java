package com.example.pr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.pr5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(LOG_TAG, "MainActivity onCreate");
    }

    protected void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "MainActivity onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "MainActivity onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "MainActivity onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "MainActivity onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity onDestroy");
    }

}