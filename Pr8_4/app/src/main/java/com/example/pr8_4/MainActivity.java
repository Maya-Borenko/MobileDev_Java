package com.example.pr8_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pr8_4.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private final static String FILE_NAME = "proba.txt";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());}
    private File getExternalPath(){
        return new File(getExternalFilesDir(null), FILE_NAME);
    }
    public void saveText(View view) {
        FileOutputStream fos = null;
        try {
            String text = binding.editor.getText().toString();
            fos = new FileOutputStream(getExternalPath());
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        } catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            throw new RuntimeException(ex);
        } finally {
            try { if(fos != null) fos.close(); }
            catch(IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();}}}

    public void openText(View view) {
        File file = getExternalPath();
        if (!file.exists()) return;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            binding.text.setText(text);} catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try { if(fin != null) fin.close(); }
            catch(IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();}}}}
