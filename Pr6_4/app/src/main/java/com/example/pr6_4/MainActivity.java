package com.example.pr6_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.example.pr6_4.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentStateAdapter pageAdapter = new MyAdapter(this);
        binding.pager.setAdapter(pageAdapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout,
                binding.pager, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText("Страница" + (position + 1));
            }
        });
        tabLayoutMediator.attach();
    }
}