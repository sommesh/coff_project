package com.example.som.justjava;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by som on 13-02-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "som.db";
    private static final String TABLENAME = "data";
    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion)
        {
            String sql1="drop table if exists"+TABLENAME;
            db.execSQL(sql1);
            this.onCreate(db);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table"+" "+TABLENAME+"(count varchar, password varchar)");
    }
}
