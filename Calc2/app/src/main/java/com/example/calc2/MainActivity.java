package com.example.calc2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.View;

import com.example.calc2.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        FragmentStateAdapter pageAdapter = new MyAdapter(this);
        binding.pager.setAdapter(pageAdapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout,
                binding.pager, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                if (position == 0)
                    tab.setText("Калькулятор");
                if (position == 1)
                    tab.setText("О программе");
                if (position == 2)
                    tab.setText("Об авторе");
            }
        });
        tabLayoutMediator.attach();
    }



}