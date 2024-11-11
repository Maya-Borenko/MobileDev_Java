package com.example.pr5_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pr5_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.onSomeEventListener {
    @Override
    public void someEvent(String s){
        Fragment1 frag1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView)).setText("Text from Fragment 2: " + s);
    }
    private ActivityMainBinding binding;
    private static final int CONTENT_VIEW_ID = 10101010;
    Fragment2 frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.fragment2.setId(CONTENT_VIEW_ID);
        frag2 = new Fragment2();

        FragmentTransaction fTrans;
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(CONTENT_VIEW_ID, frag2);
        fTrans.commit();
    }
    public void onClick(View v){
        Fragment1 frag1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView)).setText("Access to Fragment 1 from Activity");
        ((TextView) frag2.getView().findViewById(R.id.textView)).setText("Access to Fragment 2 from Activity");
    }
}