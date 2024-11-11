package com.example.pr8_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.pr8_5.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayAdapter<Cat> adapter;
    private List<Cat> cats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        cats = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cats);
        binding.list.setAdapter(adapter);}

    public void add(View view) {
        String name = binding.nameText.getText().toString();
        int age = Integer.parseInt(binding.ageText.getText().toString());
        Cat cat = new Cat(name, age);
        cats.add(cat);
        adapter.notifyDataSetChanged();}
    public void save(View view) {
        boolean result = myJSON.exportToJSON(this, cats);
        if (result) {
            Toast.makeText(this,
                    "Handle Completed Successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,
                    "Failed to Handle JSON Data", Toast.LENGTH_LONG).show();}}
    public void open(View view){
        cats = myJSON.importFromJson(this);
        if (cats!=null){
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, cats);
            binding.list.setAdapter(adapter);
            Toast.makeText(this, "Данные восстановлены",
                    Toast.LENGTH_LONG).show();}
        else{
            Toast.makeText(this, "Не удалось открыть данные",
                    Toast.LENGTH_LONG).show();}}}