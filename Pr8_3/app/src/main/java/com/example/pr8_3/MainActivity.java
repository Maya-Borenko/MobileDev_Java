package com.example.pr8_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pr8_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "Account";
    private static final String PREF_NAME = "Name";
    SharedPreferences settings;
    ActivityMainBinding binding;
    private static final String TEXT_FIELD_KEY = "text_field_value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadText();
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
    }
    @Override
    protected void onPause() {
        super.onPause();
        saveText();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveText();
    }

    private void saveText(){
        settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("string", binding.nameBox.getText().toString());
        editor.commit();
    }

    private void loadText(){
        settings = getPreferences(MODE_PRIVATE);
        String savedText  = settings.getString("string", "");
        binding.nameBox.setText(savedText);
    }
    public void saveName(View view){
        String name = binding.nameBox.getText().toString();
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_NAME, name);
        prefEditor.apply();
    }

    public void getName(View view){
        String name = settings.getString(PREF_NAME, "не определено");
        binding.nameView.setText(name);
    }
}