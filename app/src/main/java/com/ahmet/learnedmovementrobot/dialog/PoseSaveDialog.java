package com.ahmet.learnedmovementrobot.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.ahmet.learnedmovementrobot.R;

/**
 * Author: Ahmet TOPAK
 * Since: 3/6/2024
 */
public class PoseSaveDialog extends DialogFragment {


//    PoseSaveDialog dialog = new PoseSaveDialog();
//        dialog.show(getSupportFragmentManager(), "MyDialogFragment");
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // XML dosyasını inflate et
        View view = inflater.inflate(R.layout.pose_saver, null);

        // Inflate edilmiş XML düzenini dialoga ekle
        builder.setView(view);

        // Dialog oluştur ve döndür
        return builder.create();
    }
}
