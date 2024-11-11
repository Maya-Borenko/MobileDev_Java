package com.example.bmd_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bmd_shop.databinding.ActivitySecondBinding;
import com.example.bmd_shop.databinding.FooterBinding;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    View footer;
    ArrayList<Product> products;
    BoxAdapter boxAdapter;
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        products = intent.<Product>getParcelableArrayListExtra("products");
        int total = 0;
        for (int i=0; i <products.size();i++){
            total += products.get(i).price;}
        footer = createFooter("Итого:");
        ListView lvMain = binding.lvMain;
        binding.foot.addView(footer);
        TextView footerText = footer.findViewById(R.id.tvText);
        footerText.setText(total+"");
        boxAdapter = new BoxAdapter(this, products, footerText, true);
        lvMain.setAdapter(boxAdapter);
        FooterBinding footer = FooterBinding.inflate(getLayoutInflater());
        footer.tvText.setText(total+"");}
    private View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer2, null);
        ((TextView) v.findViewById(R.id.tvTitle)).setText(text);
        return v;}}