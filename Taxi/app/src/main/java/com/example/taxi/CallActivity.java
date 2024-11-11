package com.example.taxi;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivityCallBinding;

public class CallActivity extends AppCompatActivity {
    private ActivityCallBinding binding;
    private static final String TAG = "myLogs";
    ActivityResultLauncher<Intent> startPathActivityForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode() == Activity.RESULT_OK) {
                Intent intent = o.getData();
                if (intent != null) {
                    String streetFrom = intent.getStringExtra("PointFromStreet");
                    String houseFrom = intent.getStringExtra("PointFromHouse");
                    String flatFrom = intent.getStringExtra("PointFromFlat");
                    String streetTo = intent.getStringExtra("PointToStreet");
                    String houseTo = intent.getStringExtra("PointToHouse");
                    String flatTo = intent.getStringExtra("PointToFlat");
                    binding.Path.setText("Taxi will arrive at " + streetFrom + ", " + houseFrom + ", " + flatFrom + " in 5 minute's and take you in " + streetTo + ", " + houseTo + ", " + flatTo + ". If you are agree click Call Taxi");
                    binding.btnCallTaxi.setEnabled(true);
                    Log.d(TAG,"Adress data is geted");
                } else {
                    String textError = "Error!";
                    binding.Path.setText(textError);
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCallBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Bundle arguments = getIntent().getExtras();
        binding.Fi.setText(arguments.get("Name").toString());
        binding.Num.setText(arguments.get("Tel").toString());
        Log.d(TAG,"Personal data is geted");
        binding.btnCallTaxi.setEnabled(false);
        Intent intent = new Intent(this, PathActivity.class);
        binding.btnSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPathActivityForResult.launch(intent);
            }
        });
        Toast message = Toast.makeText(this, "Wait for Taxi. Good Luck!", LENGTH_SHORT);
        message.setGravity(Gravity.CENTER, 10, 0);
        binding.btnCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.show();
            }
        });
    }
}