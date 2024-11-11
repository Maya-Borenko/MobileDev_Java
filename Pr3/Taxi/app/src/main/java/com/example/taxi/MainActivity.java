package com.example.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    SharedPreferences sPref;
    private static final String TAG = "myLogs";
    private void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("Tel", binding.telepNumEnt.getText().toString());
        editor.commit();
        editor.putString("Name", binding.nameEnt.getText().toString());
        editor.commit();
        editor.putString("Surname", binding.SurnameEnt.getText().toString());
        editor.commit();
    }

    private void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText  = sPref.getString("Tel", "");
        binding.telepNumEnt.setText(savedText);
        savedText  = sPref.getString("Name", "");
        binding.nameEnt.setText(savedText);
        savedText  = sPref.getString("Surname", "");
        binding.SurnameEnt.setText(savedText);
        if (savedText!="") {
            binding.reg.setText("Log in");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity: onCreate");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loadText();
        Intent intent = new Intent(this, CallActivity.class);
        binding.reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Name", binding.nameEnt.getText().toString()+" "+binding.SurnameEnt.getText().toString());
                intent.putExtra("Tel", binding.telepNumEnt.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
        Log.d(TAG, "MainActivity: onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume");
    }
}