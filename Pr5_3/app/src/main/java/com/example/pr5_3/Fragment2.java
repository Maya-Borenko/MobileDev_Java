package com.example.pr5_3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr5_3.databinding.Fragment1Binding;
import com.example.pr5_3.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {
    final String LOG_TAG = "myLogs";
    private Fragment2Binding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public interface onSomeEventListener{
        public void someEvent(String s);
    }
    onSomeEventListener someEventListener;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            someEventListener = (onSomeEventListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must impement on SomeEventListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater, container, false);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(LOG_TAG, "Button click in Fragment2");
                someEventListener.someEvent("Test text to Fragment1");
            }
        });
        return binding.getRoot();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


}