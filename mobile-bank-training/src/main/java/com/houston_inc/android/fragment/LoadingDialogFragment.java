package com.houston_inc.android.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class LoadingDialogFragment extends DialogFragment {

    private String text;

    public LoadingDialogFragment(String text) {
        this.text = text;
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        this.setStyle(STYLE_NO_TITLE, getTheme());
        dialog.setMessage(text);
        dialog.setCancelable(false);
        return dialog;
    }

}
