package com.ahmet.learnedmovementrobot.learnedMovement;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;


/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 3/7/2024
 */

public class PositionInputListener {

    Context context;
    private final PositionManager positionManager;
    private final Button saveButton;
    private final Button updateButton;
    private final Button deleteButton;
    private final EditText nameEditText;
    private final EditText turretEditText;
    private final EditText shoulderEditText;
    private final EditText elbowEditText;
    private final EditText wristEditText;
    private final EditText clampEditText;
    private final EditText clampTurretEditText;
    private final EditText frontPalEditText;
    private final EditText backPalEditText;

    private PositionInputListener(Builder builder) {
        this.context = builder.context;
        this.positionManager = builder.positionManager;
        this.saveButton = builder.saveButton;
        this.updateButton = builder.updateButton;
        this.deleteButton = builder.deleteButton;
        this.nameEditText = builder.nameEditText;
        this.turretEditText = builder.turretEditText;
        this.shoulderEditText = builder.shoulderEditText;
        this.elbowEditText = builder.elbowEditText;
        this.wristEditText = builder.wristEditText;
        this.clampEditText = builder.clampEditText;
        this.clampTurretEditText = builder.clampTurretEditText;
        this.frontPalEditText = builder.frontPalEditText;
        this.backPalEditText = builder.backPalEditText;

        setupListeners();
    }

    private void setupListeners() {
        saveButton.setOnClickListener(v -> {
            Position position = new Position.Builder()
                    .name(getTextByEditText(nameEditText))
                    .turretAngle(getFloatValueByEditText(turretEditText))
                    .shoulderAngle(getFloatValueByEditText(shoulderEditText))
                    .elbowAngle(getFloatValueByEditText(elbowEditText))
                    .wristAngle(getFloatValueByEditText(wristEditText))
                    .clampAngle(getFloatValueByEditText(clampEditText))
                    .clampTurretAngle(getFloatValueByEditText(clampTurretEditText))
                    .frontPalAngle(getFloatValueByEditText(frontPalEditText))
                    .backPalAngle(getFloatValueByEditText(backPalEditText)).build();


            try {
                positionManager.addPosition(position);
            } catch (PositionException e) {
                showToastMessage(e.getMessage());
            }
        });

        updateButton.setOnClickListener(v -> {
            // Update button click listener logic
        });

        deleteButton.setOnClickListener(v -> {
            // Delete button click listener logic
        });

    }


    private String getTextByEditText(EditText editText){

        return editText.getText().toString();

    }
    private float getFloatValueByEditText(EditText editText){

        return Float.valueOf(editText.getText().toString());
    }

    private void showToastMessage(String message){

        if (context != null){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
    public static class Builder {
        private Context context;
        private PositionManager positionManager;
        private Button saveButton;
        private Button updateButton;
        private Button deleteButton;
        private EditText nameEditText;
        private EditText turretEditText;
        private EditText shoulderEditText;
        private EditText elbowEditText;
        private EditText wristEditText;
        private EditText clampEditText;
        private EditText clampTurretEditText;
        private EditText frontPalEditText;
        private EditText backPalEditText;
        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }
        public Builder setPositionManager(PositionManager positionManager) {
            this.positionManager = positionManager;
            return this;
        }

        public Builder setSaveButton(Button saveButton) {
            this.saveButton = saveButton;
            return this;
        }

        public Builder setUpdateButton(Button updateButton) {
            this.updateButton = updateButton;
            return this;
        }

        public Builder setDeleteButton(Button deleteButton) {
            this.deleteButton = deleteButton;
            return this;
        }

        public Builder setNameEditText(EditText nameEditText) {
            this.nameEditText = nameEditText;
            return this;
        }

        public Builder setTurretEditText(EditText turretEditText) {
            this.turretEditText = turretEditText;
            return this;
        }

        public Builder setShoulderEditText(EditText shoulderEditText) {
            this.shoulderEditText = shoulderEditText;
            return this;
        }

        public Builder setElbowEditText(EditText elbowEditText) {
            this.elbowEditText = elbowEditText;
            return this;
        }

        public Builder setWristEditText(EditText wristEditText) {
            this.wristEditText = wristEditText;
            return this;
        }

        public Builder setClampEditText(EditText clampEditText) {
            this.clampEditText = clampEditText;
            return this;
        }

        public Builder setClampTurretEditText(EditText clampTurretEditText) {
            this.clampTurretEditText = clampTurretEditText;
            return this;
        }

        public Builder setFrontPalEditText(EditText frontPalEditText) {
            this.frontPalEditText = frontPalEditText;
            return this;
        }

        public Builder setBackPalEditText(EditText backPalEditText) {
            this.backPalEditText = backPalEditText;
            return this;
        }

        public PositionInputListener build() {
            return new PositionInputListener(this);
        }
    }
}
