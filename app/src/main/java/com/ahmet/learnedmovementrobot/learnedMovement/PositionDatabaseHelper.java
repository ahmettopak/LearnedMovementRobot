package com.ahmet.learnedmovementrobot.learnedMovement;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 3/7/2024
 */

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PositionDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "positions.db";
    private static final String TABLE_NAME = "positions_table";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_TURRET_ANGLE = "TURRET_ANGLE";
    private static final String COL_SHOULDER_ANGLE = "SHOULDER_ANGLE";
    private static final String COL_ELBOW_ANGLE = "ELBOW_ANGLE";
    private static final String COL_WRIST_ANGLE = "WRIST_ANGLE";
    private static final String COL_CLAMP_ANGLE = "CLAMP_ANGLE";
    private static final String COL_CLAMP_TURRET_ANGLE = "CLAMP_TURRET_ANGLE";
    private static final String COL_FRONT_PAL_ANGLE = "FRONT_PAL_ANGLE";
    private static final String COL_BACK_PAL_ANGLE = "BACK_PAL_ANGLE";

    public PositionDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_TURRET_ANGLE + " REAL, "
                + COL_SHOULDER_ANGLE + " REAL, "
                + COL_ELBOW_ANGLE + " REAL, "
                + COL_WRIST_ANGLE + " REAL, "
                + COL_CLAMP_ANGLE + " REAL, "
                + COL_CLAMP_TURRET_ANGLE + " REAL, "
                + COL_FRONT_PAL_ANGLE + " REAL, "
                + COL_BACK_PAL_ANGLE + " REAL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addPosition(Position position) throws PositionException {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_NAME, position.getName());
            contentValues.put(COL_TURRET_ANGLE, position.getTurretAngle());
            contentValues.put(COL_SHOULDER_ANGLE, position.getShoulderAngle());
            contentValues.put(COL_ELBOW_ANGLE, position.getElbowAngle());
            contentValues.put(COL_WRIST_ANGLE, position.getWristAngle());
            contentValues.put(COL_CLAMP_ANGLE, position.getClampAngle());
            contentValues.put(COL_CLAMP_TURRET_ANGLE, position.getClampTurretAngle());
            contentValues.put(COL_FRONT_PAL_ANGLE, position.getFrontPalAngle());
            contentValues.put(COL_BACK_PAL_ANGLE, position.getBackPalAngle());

            long result = db.insert(TABLE_NAME, null, contentValues);
            return result != -1;
        } catch (Exception e) {
            throw new PositionException("Pozisyon eklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    @SuppressLint("Range")
    public List<Position> getAllPositions() throws PositionException {
        try {
            List<Position> positionsList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery, null);

            // Sorgulanan alanlar mevcut mu?
            if (cursor != null && cursor.getCount() > 0) {
                // Eğer kayıt bulunursa
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                    float turretAngle = cursor.getFloat(cursor.getColumnIndex(COL_TURRET_ANGLE));
                    float shoulderAngle = cursor.getFloat(cursor.getColumnIndex(COL_SHOULDER_ANGLE));
                    float elbowAngle = cursor.getFloat(cursor.getColumnIndex(COL_ELBOW_ANGLE));
                    float wristAngle = cursor.getFloat(cursor.getColumnIndex(COL_WRIST_ANGLE));
                    float clampAngle = cursor.getFloat(cursor.getColumnIndex(COL_CLAMP_ANGLE));
                    float clampTurretAngle = cursor.getFloat(cursor.getColumnIndex(COL_CLAMP_TURRET_ANGLE));
                    float frontPalAngle = cursor.getFloat(cursor.getColumnIndex(COL_FRONT_PAL_ANGLE));
                    float backPalAngle = cursor.getFloat(cursor.getColumnIndex(COL_BACK_PAL_ANGLE));

                    Position position = new Position(name, turretAngle, shoulderAngle, elbowAngle, wristAngle,
                            clampAngle, clampTurretAngle, frontPalAngle, backPalAngle);
                    positionsList.add(position);
                }
                cursor.close();
            }
            return positionsList;
        } catch (Exception e) {
            throw new PositionException("Tüm pozisyonlar alınırken bir hata oluştu: " + e.getMessage());
        }
    }

    @SuppressLint("Range")
    public List<String> getAllPositionNames() throws PositionException {
        try {
            List<String> positionNames = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT " + COL_NAME + " FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery, null);

            // Sorgulanan alanlar mevcut mu?
            if (cursor != null && cursor.getCount() > 0) {
                // Eğer kayıt bulunursa
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                    positionNames.add(name);
                }
                cursor.close();
            }
            return positionNames;
        } catch (Exception e) {
            throw new PositionException("Tüm pozisyon adları alınırken bir hata oluştu: " + e.getMessage());
        }
    }

    @SuppressLint("Range")
    public Position getPositionByName(String name) throws PositionException {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME + " = ?";
            Cursor cursor = db.rawQuery(selectQuery, new String[]{name});

            Position position = null;
            // Sorgulanan alanlar mevcut mu?
            if (cursor != null && cursor.moveToFirst()) {
                float turretAngle = cursor.getFloat(cursor.getColumnIndex(COL_TURRET_ANGLE));
                float shoulderAngle = cursor.getFloat(cursor.getColumnIndex(COL_SHOULDER_ANGLE));
                float elbowAngle = cursor.getFloat(cursor.getColumnIndex(COL_ELBOW_ANGLE));
                float wristAngle = cursor.getFloat(cursor.getColumnIndex(COL_WRIST_ANGLE));
                float clampAngle = cursor.getFloat(cursor.getColumnIndex(COL_CLAMP_ANGLE));
                float clampTurretAngle = cursor.getFloat(cursor.getColumnIndex(COL_CLAMP_TURRET_ANGLE));
                float frontPalAngle = cursor.getFloat(cursor.getColumnIndex(COL_FRONT_PAL_ANGLE));
                float backPalAngle = cursor.getFloat(cursor.getColumnIndex(COL_BACK_PAL_ANGLE));

                position = new Position(name, turretAngle, shoulderAngle, elbowAngle, wristAngle,
                        clampAngle, clampTurretAngle, frontPalAngle, backPalAngle);
                cursor.close();
            }
            return position;
        } catch (Exception e) {
            throw new PositionException("Pozisyon adına göre pozisyon alınırken bir hata oluştu: " + e.getMessage());
        }
    }

    public boolean updatePosition(Position position) throws PositionException {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_NAME, position.getName());
            contentValues.put(COL_TURRET_ANGLE, position.getTurretAngle());
            contentValues.put(COL_SHOULDER_ANGLE, position.getShoulderAngle());
            contentValues.put(COL_ELBOW_ANGLE, position.getElbowAngle());
            contentValues.put(COL_WRIST_ANGLE, position.getWristAngle());
            contentValues.put(COL_CLAMP_ANGLE, position.getClampAngle());
            contentValues.put(COL_CLAMP_TURRET_ANGLE, position.getClampTurretAngle());
            contentValues.put(COL_FRONT_PAL_ANGLE, position.getFrontPalAngle());
            contentValues.put(COL_BACK_PAL_ANGLE, position.getBackPalAngle());

            int result = db.update(TABLE_NAME, contentValues, COL_NAME + " = ?", new String[]{position.getName()});
            if (result == 0) {
                throw new PositionException("Pozisyon güncellenirken bir hata oluştu. Güncellenecek pozisyon bulunamadı.");
            }
            return true;
        } catch (Exception e) {
            throw new PositionException("Pozisyon güncellenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public boolean deletePosition(String positionName) throws PositionException {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            int result = db.delete(TABLE_NAME, COL_NAME + " = ?", new String[]{positionName});
            if (result == 0) {
                throw new PositionException("Pozisyon silinirken bir hata oluştu. Silinecek pozisyon bulunamadı.");
            }
            return true;
        } catch (Exception e) {
            throw new PositionException("Pozisyon silinirken bir hata oluştu: " + e.getMessage());
        }
    }

}