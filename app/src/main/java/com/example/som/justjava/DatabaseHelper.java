package com.example.som.justjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by som on 13-02-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=4;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_UNAME="uname";
    private static final String COLUMN_PASS="pass";
    private static final String TAG = "DatabaseHelper";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = " CREATE TABLE contacts( name  TEXT NOT NULL ,email TEXT NOT NULL , uname TEXT NOT NULL , pass TEXT NOT NULL ) ; ";


    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
   
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertContact(contact c)
    {
        db= this.getWritableDatabase();

        ContentValues values=new ContentValues();

        String query="SELECT *from contacts ";
        Cursor cursor=db.rawQuery(query, null);

        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        Log.v(TAG, "INSERTED the data successfully  ");
        db.close();
    }

public String searchPass(String uname) throws SQLException {
    db = this.getReadableDatabase();
    //String query =  "select uname, pass from "+TABLE_NAME;
    Cursor cursor = db.rawQuery("select uname,pass from " + TABLE_NAME, null);
    Log.v(TAG, "SELECTED NAME AND PASS  ");
    String a, b,c;
    c = "not found";
    if (cursor != null) {
        while (cursor.moveToNext()) {
            a = cursor.getString(cursor.getColumnIndex(COLUMN_UNAME));
            if (a.equals(uname)) {
                b = cursor.getString(cursor.getColumnIndex(COLUMN_PASS));
                break;
            }
        }
    }
    return c;
}
    //
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
