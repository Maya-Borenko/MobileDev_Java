package com.example.pr8_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.pr8_1_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    User user = new User("undefined",0);
    final static String userVariableKey = "USER_VARIABLE_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);}
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(userVariableKey, user);
        super.onSaveInstanceState(outState);}
    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        user = (User) savedInstanceState.getSerializable(userVariableKey);
        binding.dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());}
    public void saveData(View view) {
        String name = binding.nameBox.getText().toString();
        int age = 0;
        try {
            age = Integer.parseInt(binding.yearBox.getText().toString());}
        catch (NumberFormatException ex) {}
        user = new User(name, age);}
    @SuppressLint("SetTextI18n")
    public void getData(View view){
        binding.dataView.setText("Name: " + user.getName() + "Age: " + user.getAge());}}