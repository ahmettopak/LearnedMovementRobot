package com.ahmet.learnedmovementrobot.learnedMovement;

import android.content.Context;

import java.util.List;

/**
 * Author: Ahmet TOPAK
 * Since: 3/6/2024
 */
public class PositionManager {
    PositionDatabaseHelper positionDatabaseHelper;
    Context context;

    public PositionManager(Context context){
        this.context = context;
        positionDatabaseHelper = new PositionDatabaseHelper(context);
    }
    public boolean addPosition(Position position) throws PositionException{
        return positionDatabaseHelper.addPosition(position);
    }

    public boolean deletePosition(String positionName) throws PositionException{
        return positionDatabaseHelper.deletePosition(positionName);
    }

    public boolean updatePosition(Position position) throws PositionException{
        return positionDatabaseHelper.updatePosition(position);
    }

    public List<String> getAllPositionsName() throws PositionException{
        List<String> allPositionNames = positionDatabaseHelper.getAllPositionNames();
        return allPositionNames;
    }
    public List<Position> getAllPositions() throws PositionException{
        List<Position> allPositions = positionDatabaseHelper.getAllPositions();
        return allPositions;
    }
    public Position getPositionByName(String selectedPositionName) throws PositionException{
        Position selectedPosition = positionDatabaseHelper.getPositionByName(selectedPositionName);
        return selectedPosition;
    }
}
