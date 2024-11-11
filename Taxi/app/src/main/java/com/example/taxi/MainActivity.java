package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.taxi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    SharedPreferences sPref;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loadText();
        Log.d(TAG,"Text is load");
        Intent intent = new Intent(this, CallActivity.class);
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Name", binding.name.getText().toString()+" "+binding.surname.getText().toString());
                intent.putExtra("Tel", binding.telNum.getText().toString());
                setResult(RESULT_OK, intent);
                Log.d(TAG,"Text is transmitted");
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Text is saved");
        saveText();
    }

    private void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("Tel", binding.telNum.getText().toString());
        editor.commit();
        editor.putString("Name", binding.name.getText().toString());
        editor.commit();
        editor.putString("Surname", binding.surname.getText().toString());
        editor.commit();
    }

    private void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText  = sPref.getString("Tel", "");
        binding.telNum.setText(savedText);
        savedText  = sPref.getString("Name", "");
        binding.name.setText(savedText);
        savedText  = sPref.getString("Surname", "");
        binding.surname.setText(savedText);
        if (savedText!="") {
            binding.btnSignIn.setText("Log in");
        }
    }

}