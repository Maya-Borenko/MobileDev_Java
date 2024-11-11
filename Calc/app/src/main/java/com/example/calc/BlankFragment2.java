package com.example.calc;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calc.databinding.FragmentBlank2Binding;

public class BlankFragment2 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    FragmentBlank2Binding binding;

    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlank2Binding.inflate(inflater, container, false);
        binding.num.setShowSoftInputOnFocus(false);
        binding.step.setShowSoftInputOnFocus(false);
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.num.setTextColor(Color.BLACK);
                binding.step.setTextColor(Color.BLACK);
                binding.num.setText("");
                binding.step.setText("");
                binding.res.setText("");
            }
        });
        return binding.getRoot();
    }
}