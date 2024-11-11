package com.example.pr6_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pr6_1_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 4, "exit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(1, binding.chbExtMenu.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String sb = "Item Menu"+
                "\r\n groupId: " + String.valueOf(item.getGroupId()) +
                "\r\n itemId: " + String.valueOf(item.getItemId()) +
                "\r\n order: " + String.valueOf(item.getOrder()) +
                "\r\n title: " + String.valueOf(item.getTitle());
        binding.textView.setText(sb);
        return super.onOptionsItemSelected(item);
    }
}