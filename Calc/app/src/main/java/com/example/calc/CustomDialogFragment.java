package com.example.calc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomDialogFragment extends DialogFragment {
private static final String TAG = "MyLogs";
@NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Log.d(TAG, "onCreateDialog");
        AlertDialog.Builder builder = new AlertDialog
                .Builder(getActivity());
        return builder
                .setTitle("Выход")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.fragment_custom_dialog)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();                    }                })
                .setNegativeButton("Отмена" ,null)
                .create();    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.d(TAG, "onAttach");    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");    }
    @Override
    public void onDetach(){
        super.onDetach();
        Log.d(TAG, "onDetach");    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");    }}