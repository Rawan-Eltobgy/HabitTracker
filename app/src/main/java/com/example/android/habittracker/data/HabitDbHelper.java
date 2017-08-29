package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 8/28/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habitTracker.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_HABIT_TRACKING = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME +
                "(" + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitContract.HabitEntry.COLUMN_DAY + " INTEGER NOT NULL," +
                HabitContract.HabitEntry.COLUMN_HABIT + " STRING);";
        Log.v("HabitDbHelper", "create table: " + CREATE_TABLE_HABIT_TRACKING);
        sqLiteDatabase.execSQL(CREATE_TABLE_HABIT_TRACKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertHabit(int day, String habit) {
        Log.v("HabitDbHelper", "Inserting .... ");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_DAY, day);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT, habit);
        values.put(HabitContract.HabitEntry.COLUMN_DAY, 1);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT, "Android Course.");
        values.put(HabitContract.HabitEntry.COLUMN_DAY, 2);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT, "IOS Course.");
        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabits() {
        Log.v("HabitDbHelper", "Reading.... ");
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_DAY,
                HabitContract.HabitEntry.COLUMN_HABIT
        };
        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
