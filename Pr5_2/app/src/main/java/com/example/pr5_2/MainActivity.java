package com.example.pr5_2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.pr5_2.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    FragmentTransaction fTrans;
    BlankFragment1 frag1;
    BlankFragment2 frag2;
    private static final int CONTENT_VIEW_TO = 10101010;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.fragmentContainer.setId(CONTENT_VIEW_TO);
        frag1 = new BlankFragment1();
        frag2 = new BlankFragment2();
        binding.Add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null){
                    fTrans = getSupportFragmentManager().beginTransaction();
                    fTrans.add(CONTENT_VIEW_TO, frag1);
                    if (binding.swStack.isChecked()){fTrans.addToBackStack(null);}
                    fTrans.commit();}}});
        binding.Remove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.remove(frag1);
                if (binding.swStack.isChecked()){fTrans.addToBackStack(null);}
                fTrans.commit();}});
        binding.Replace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.replace(CONTENT_VIEW_TO, frag2);
                if (binding.swStack.isChecked()){fTrans.addToBackStack(null);}
                fTrans.commit();}});}}