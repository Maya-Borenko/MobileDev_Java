package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.taxi.databinding.ActivityPathBinding;

public class PathActivity extends AppCompatActivity {
    private ActivityPathBinding binding;
    private static final String TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Log.d(TAG, "Adress data is transmited");
                finish();
            }
        });
        updateMusic(true);
        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateMusic(isChecked);
            }
        });
    }

    public void updateMusic(boolean isChecked) {
        Intent i = new Intent(this, MediaService.class);
        if (isChecked) {
            startService(i);
        } else {
            stopService(i);
        }
    }
}