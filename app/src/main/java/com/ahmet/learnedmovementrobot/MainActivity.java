package com.ahmet.learnedmovementrobot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ahmet.learnedmovementrobot.databinding.ActivityMainBinding;
import com.ahmet.learnedmovementrobot.learnedMovement.Position;
import com.ahmet.learnedmovementrobot.learnedMovement.PositionDatabaseHelper;
import com.ahmet.learnedmovementrobot.learnedMovement.PositionException;
import com.ahmet.learnedmovementrobot.learnedMovement.PositionInputListener;
import com.ahmet.learnedmovementrobot.learnedMovement.PositionManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomListView.OnItemSelectedListener{
    ActivityMainBinding binding;
    PositionManager positionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        positionManager = new PositionManager(this);
        PositionInputListener positionInputListener = new PositionInputListener.Builder()
                .setPositionManager(positionManager)
                .setSaveButton(binding.savePositionButton)
                .setUpdateButton(binding.updatePositionButton)
                .setDeleteButton(binding.deletePositionButton)
                .setNameEditText(binding.nameEditText)
                .setTurretEditText(binding.turretEditText)
                .setShoulderEditText(binding.shoulderEditText)
                .setElbowEditText(binding.elbowEditText)
                .setWristEditText(binding.wristEditText)
                .setClampEditText(binding.clampEditText)
                .setClampTurretEditText(binding.clampTurretEditText)
                .setFrontPalEditText(binding.frontPalEditText)
                .setBackPalEditText(binding.backPalEditText)
                .build();

        binding.positionListView.setOnItemSelectedListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();


        try {
            binding.positionListView.setData(positionManager.getAllPositionsName());
        } catch (PositionException e) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
//        for (String positionName : allPositionNames) {
//            System.out.println("Pozisyon adı: " + positionName);
//        }
//
//        String selectedPositionName = "Pozisyon1";
//
//
//        if (selectedPosition != null) {
//            System.out.println("Seçilen Pozisyon Bilgileri:");
//            System.out.println("Adı: " + selectedPosition.getName());
//            System.out.println("Turret Angle: " + selectedPosition.getTurretAngle());
//            System.out.println("Shoulder Angle: " + selectedPosition.getShoulderAngle());
//            System.out.println("Elbow Angle: " + selectedPosition.getElbowAngle());
//            System.out.println("Wrist Angle: " + selectedPosition.getWristAngle());
//            System.out.println("Clamp Angle: " + selectedPosition.getClampAngle());
//            System.out.println("Clamp Turret Angle: " + selectedPosition.getClampTurretAngle());
//            System.out.println("Front Pal Angle: " + selectedPosition.getFrontPalAngle());
//            System.out.println("Back Pal Angle: " + selectedPosition.getBackPalAngle());
//        } else {
//            System.out.println("Seçilen pozisyon bulunamadı.");
//        }
    }

    @Override
    public void onItemSelected(String selectedItem) {
        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
    }
}