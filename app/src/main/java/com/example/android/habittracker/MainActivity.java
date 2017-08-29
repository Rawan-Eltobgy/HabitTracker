package com.example.android.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.android.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    /**
     * Database helper that will provide us access to the database
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.


        HabitDbHelper mDbHelper = new HabitDbHelper(this);
        mDbHelper.insertHabit(0, "Studying");
        /**
         * Temporary helper method to display information in the onscreen TextView about the state of
         * the pets database.
         */

        TextView displayView = (TextView) findViewById(R.id.text_view_data);
        Cursor cursor = mDbHelper.readHabits();
        while (cursor.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            /**int currentID = cursor.getInt(idColumnIndex);
             String currentDay = cursor.getString(dayColumnIndex);
             String currentHabit = cursor.getString(habitColumnIndex);**/
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) );
        }


    }


}




