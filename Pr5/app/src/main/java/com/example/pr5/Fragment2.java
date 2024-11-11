package com.example.pr5;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pr5.databinding.Fragment1Binding;

public class Fragment2 extends Fragment {
    private Fragment1Binding binding;
    final String LOG_TAG = "myLogs";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(LOG_TAG, "Fragment2 onAttach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onCreate");
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.d(LOG_TAG, "Fragment2 onCreateView");
        binding = Fragment1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState){
        super.onViewStateRestored(savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onViewStateRestored");
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "Fragment2 onStart");
    }

    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "Fragment2 onResume");
    }

    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "Fragment2 onPause");
    }

    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "Fragment2 onStop");
    }

    public void onDestroyView(){
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment2 onDestroyView");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment2 onDestroy");
    }

    public void onDetach(){
        super.onDetach();
        Log.d(LOG_TAG, "Fragment2 onDetach");
    }
}