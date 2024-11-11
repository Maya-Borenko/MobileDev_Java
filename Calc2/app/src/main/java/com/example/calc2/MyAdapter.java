package com.example.calc2;

import androidx.annotation.NonNull;import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.List;
public class MyAdapter extends FragmentStateAdapter {    private List<Fragment> fragments;
    public MyAdapter(FragmentActivity fragmentActivity) {        super(fragmentActivity);
        fragments = new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new Info());
    }
    @NonNull
    @Override    public Fragment createFragment(int position) {
        return fragments.get(position);    }
    @Override    public int getItemCount() {
        return fragments.size();    }
    public void setFragment(int position, Fragment fragment) {
        fragments.set(position, fragment);
    }}
