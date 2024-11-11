package com.example.pr7_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.pr7_4.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Removable{
    ArrayAdapter<String> adapter;
    @Override
    public void remove(String name) {
        adapter.remove(name);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ArrayList<String> phones = new ArrayList<>();
        phones.add("Apple iPhone 14");
        phones.add("Nokia XR20");
        phones.add("Xiaomi Redmi Note 12 Pro");
        phones.add("Samsung Galaxy S25 Ultra");
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                phones);
        binding.phonesList.setAdapter(adapter);
        binding.phonesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPhone = adapter.getItem(position);
                CustomDialogFragment dialog = new CustomDialogFragment();
                Bundle args = new Bundle();
                args.putString("phone", selectedPhone);
                dialog.setArguments(args);
                dialog.show(getSupportFragmentManager(), "custom");}        });    }


}