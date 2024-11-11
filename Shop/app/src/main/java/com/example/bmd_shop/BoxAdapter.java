package com.example.bmd_shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.bmd_shop.databinding.ItemBinding;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;
    TextView footerTextView;
    ItemBinding binding;
    boolean kauf;
    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener(){
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            getProduct((Integer)buttonView.getTag()).box = isChecked;
            if (kauf)
                footerTextView.setText(getCost()+"");
            else
                footerTextView.setText("Выбрано товаров: " + getBox().size());}};
    BoxAdapter(Context context, ArrayList<Product> products, TextView footerText, boolean _kauf){
        ctx = context;
        objects = products;
        footerTextView = footerText;
        kauf = _kauf;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);}
    @Override
    public int getCount() {
        return objects.size();
    }
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        binding = ItemBinding.inflate(LayoutInflater.from(ctx));
        Product p = getProduct(position);
        binding.tvDescr.setText(p.name);
        binding.tvPrice.setText(p.price + "");
        binding.ivImage.setImageResource(p.image);
        CheckBox cbBuy = binding.cbBox;
        cbBuy.setText(p.id+"");
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);
        return binding.getRoot(); }
    public int getCost(){
        int total = 0;
        for (Product p : objects){
            if (p.box)
                total += p.price;}
        return total;}
    private Product getProduct(int position) {return ((Product) getItem(position));}
    ArrayList<Product> getBox(){
        ArrayList<Product> box = new ArrayList<Product>();
        for (Product p : objects){
            if (p.box)
                box.add(p);}
        return box;}}
