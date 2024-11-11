package com.example.pr7_3;

import androidx.appcompat.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import androidx.annotation.NonNull;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Диалоговое oкно")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.fragment_custom_dialog)
                .setPositiveButton(R.string.Ok, null)
                .setNegativeButton(R.string.No, null)
                .create();
    }
}