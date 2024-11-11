package com.example.bmd_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.content.Context;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmd_shop.databinding.ActivityMainBinding;
import com.example.bmd_shop.databinding.FooterBinding;
import com.example.bmd_shop.databinding.ItemBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;
    private ActivityMainBinding binding;
    public FooterBinding footerBinding;
    View footer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        footer1 = createFooter("Корзина");
        //footer2 = createFooter("footer 2");
        fillData();
        ListView lvMain = binding.lvMain;
        binding.foot.addView(footer1);
        boxAdapter = new BoxAdapter(this, products, footer1.findViewById(R.id.tvText), false);
        lvMain.setAdapter(boxAdapter);}
    private View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView) v.findViewById(R.id.tvTitle)).setText(text);
        return v;}
    private void fillData() {
        int[] images = {R.drawable.pngwing_com, R.drawable.pngwing_com_1_, R.drawable.pngwing_com_2_,
                R.drawable.pngwing_com_3_, R.drawable.pngwing_com_4_, R.drawable.pngwing_com_5_,
                R.drawable.pngwing_com_6_, R.drawable.pngwing_com_7_, R.drawable.pngwing_com_8_,
                R.drawable.pngwing_com_9_, R.drawable.pngwing_com_10_, R.drawable.pngwing_com_11_, };
        String[] names = {"Набор белых ваз", "Голубая ваза", "Тонкая ваза", "Зеленая ваза",
                "Прозрачная ваза", "Ваза с лентой", "Ваза-бочонок", "Ваза царская", "Ваза простая",
                "Ваза большая", "Набор ваз ручной работы", "Ваза, ручная роспись"};
        for (int i=1; i <=20; i++){
            products.add(new Product(i, names[i%11], i*1000/11, images[i%11], false)); } }
    public void showResult(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("products", boxAdapter.getBox());
        startActivity(intent);}}