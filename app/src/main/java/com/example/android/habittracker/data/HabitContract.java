package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by user on 8/28/2017.
 */
public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {}

    public static abstract class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "Habit_Tracker";
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_DAY="day";

        public final static String COLUMN_HABIT = "habit";

        /**
         * Day of the week.
         *
         * The only possible values are {Days of the week}.
         *
         * Type: INTEGER
         */

        /**
         * Possible values for the day of the week.
         */
        public static final int Saturday= 1;
        public static final int Sunday= 2;
        public static final int Monday = 3;
        public static final int Tuesaday= 4;
        public static final int Wensday= 5;
        public static final int Thursday = 6;
        public static final int Friday = 7;
    }}
