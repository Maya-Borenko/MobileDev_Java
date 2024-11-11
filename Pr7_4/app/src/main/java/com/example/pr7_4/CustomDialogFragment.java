package com.example.pr7_4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomDialogFragment extends DialogFragment {
    private Removable removable;

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        removable = (Removable) context;
    }
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        assert getArguments() != null;
        String phone = getArguments().getString("phone");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        return builder
                .setTitle("Alert Dialog")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Удалить " + phone + "?")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removable.remove(phone);
                    }
                })
                .setNegativeButton("Отмена", null)
                .create();
    }
}