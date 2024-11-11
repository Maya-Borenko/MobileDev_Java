package com.example.calc2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.calc2.databinding.FragmentBlank1Binding;


public class BlankFragment1 extends Fragment {
    public interface OnSelectedButtonListener {
        void onButtonSelected(String ty, String write, String button);

    }
    public interface GetNums {
        void getNums();
    }
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private String correct;
    FragmentBlank1Binding binding;
    public BlankFragment1() {
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
        binding = FragmentBlank1Binding.inflate(inflater, container, false);
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
        binding.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("0");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("0");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("0");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("0");
//                }
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("1");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("1");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("1");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("1");
//                }
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("2");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("2");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("2");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("2");
//                }
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("3");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("3");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("3");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("3");
//                }
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("4");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("4");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("4");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("4");
//                }
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("5");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("5");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("5");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("5");
//                }
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.num.append("6");
                if (binding.num.hasFocus()){
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("6");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("6");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("6");
//                }
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("7");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("7");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("7");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("7");
//                }
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("8");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("8");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("8");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("8");
//                }
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("9");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("9");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("9");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("9");
//                }
            }
        });
        binding.btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.step.hasFocus()){
                    ((TextView)binding.step).append("/");
                }
//                if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("/");
//                }
            }
        });
        binding.btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int number = Integer.parseInt(String.valueOf(((TextView)binding.fragment2.findViewById(R.id.num)).getText()));
//                String[] powerAll = String.valueOf(((TextView)binding.fragment2.findViewById(R.id.step)).getText()).split("/");
                int number = Integer.parseInt(String.valueOf(((TextView)binding.num).getText()));
                String[] powerAll = String.valueOf(((TextView)binding.step).getText()).split("/");
                double power1 = Integer.parseInt(powerAll[0]);
                String ans = "";
                if (powerAll.length > 1) {
                    double power2 = Integer.parseInt(powerAll[1]);
                    if (power2!=0){
                        if ((power2%2==0 && number >=0) || power2%2!=0 || (number == 0 && power1/power2 > 0)) {
                            ans = String.valueOf(Math.pow(number, power1 / power2));
                        }
                        else {
                            ans = "Ошибка!";
                        }
                    }
                    else{
                        ans = "Ошибка!";
                        correct = "Деление на ноль!";
                    }
                }
                else{
                    if (number == 0 && power1 <= 0) {
                        ans = "Ошибка!";
                        correct = "Ноль в нулевой!";
                    }
                    else {
                        ans = String.valueOf(Math.pow(number, power1));
                        correct = "Ошибки нет";
                    }
                }
                //((TextView) binding.fragment2.findViewById(R.id.res)).setText(ans);

            }
        });
        binding.btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.num.hasFocus()){
                    binding.num.setText("-");
                }
                else if (binding.step.hasFocus()) {
                    binding.step.setText("-");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).setText("-");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).setText("-");
//                }
            }
        });
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