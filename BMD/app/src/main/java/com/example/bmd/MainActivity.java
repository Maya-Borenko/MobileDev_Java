package com.example.bmd;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmd.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    SharedPreferences sPref;
    final String keyName = "Боренко Майя Денисовна";
    private void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(keyName, binding.textView.getText().toString());
        editor.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText  = sPref.getString(keyName, "");
        binding.textView.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
    ActivityResultLauncher<Intent> startSecondActivityForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode()== Activity.RESULT_OK){
                Intent intent = o.getData();
                if (intent != null){
                    String name = intent.getStringExtra("Name");
                    binding.textView.setText(name);
                }
                else{
                    String textError = "Error!";
                    binding.textView.setText(textError);
                }
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Toast fio = Toast.makeText(this, "Боренко Майя Денисовна", Toast.LENGTH_SHORT);
        fio.setGravity(Gravity.CENTER, 10, 0);
        fio.show();
        saveText();
        Intent intent = new Intent(this, SecondActivity.class);
        binding.act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivityForResult.launch(intent);
                //startActivity(intent);
            }
        });
    }

    private static final String TAG = "myLogs";
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loadText();
        Log.d(TAG, "MainActivity: onDestroy");
    }
}