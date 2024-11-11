package com.example.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxi.databinding.ActivityPathBinding;

public class PathActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";
    private ActivityPathBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "PathActivity: onCreate");
        binding = ActivityPathBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("PointFromStreet", binding.streetFEnt.getText().toString());
                intent.putExtra("PointFromHouse", binding.houseFEnt.getText().toString());
                intent.putExtra("PointFromFlat", binding.flatFEnt.getText().toString());
                intent.putExtra("PointToStreet", binding.streetTEnt.getText().toString());
                intent.putExtra("PointToHouse", binding.houseTEnt.getText().toString());
                intent.putExtra("PointToFlat", binding.flatTEnt.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "PathActivity: onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "PathActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "PathActivity: onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "PathActivity: onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "PathActivity: onResume");
    }
}