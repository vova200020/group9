package com.example.parknow;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookingDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Booking.db";
    public static final String TABLE_NAME = "booking_table";

    public static final String COL_1 = "BookingID";
    public static final String COL_2 = "RenterID";
    public static final String COL_3 = "RenteeID";
    public static final String COL_4 = "LocationID";
    public static final String COL_5 = "Destination";
    public static final String COL_6 = "VehicleDetails";
    public static final String COL_7 = "Date";
    public static final String COL_8 = "StartTime";
    public static final String COL_9 = "EndTime";
    public static final String COL_10 = "TotalPrice";

    public BookingDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db =  this.getWritableDatabase();//creates database and table
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + TABLE_NAME + " (BookingID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "RenterID INTEGER, RenteeID INTEGER, LocationID INTEGER, Destination ALPHANUMERIC, VehicleDetails ALPHANUMERIC," +
                "Date INTEGER, StartTime INTEGER, EndTime INTEGER, TotalPrice INTEGER, FOREIGN KEY(RenterID) REFERENCES COL_2(RenterID)," +
                "FOREIGN KEY(RenteeID) REFERENCES COL_3(RenteeID), FOREIGN KEY(LocationID) REFERENCES COL_4(LocationID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
