package com.example.som.justjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by som on 13-02-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=2;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_UNAME="uname";
    private static final String COLUMN_PASS="pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+"INT PRIMARY KEY NOT NULL AUTOINCREMENT, "+COLUMN_NAME+" VARCHAR(255) NOT NULL, "
            +COLUMN_EMAIL+" VARCHAR(255) NOT NULL, "+COLUMN_UNAME+" VARCHAR(255) NOT NULL, "+COLUMN_PASS+"VARCHAR(255) NOT NULL);";


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

        String query="select"+COLUMN_ID+ ","+COLUMN_NAME+ ","+COLUMN_EMAIL +","+COLUMN_UNAME +","+COLUMN_PASS + "from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query, null);
        int count=cursor.getCount();


        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS, c.getPass());



        db.insert(TABLE_NAME, null, values);
        db.close();





    }

public String searchPass(String uname)
{
    db=this.getReadableDatabase();
    String query="Select "+COLUMN_UNAME +", "+COLUMN_PASS+" from "+TABLE_NAME;
    Cursor cursor= db.rawQuery(query,null);
    String a,b;
    b="not found";
    if (cursor.moveToFirst())
    {
        do{
            a=cursor.getString(3);

            if (a.equals(uname))
        {
            b=cursor.getString(4);
            break;
        }
          }
        while (cursor.moveToLast());
    }
return  b;
}

    //
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String Query ="DROP TABLE IF EXITS "+TABLE_NAME;
        db.execSQL(Query);
        this.onCreate(db);
    }
}
