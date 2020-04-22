package com.example.sqllitewithrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabse extends SQLiteOpenHelper
{

    public MyDatabse(@Nullable Context context)
    {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table user(id integer primary key autoincrement, username varchar(20),number varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public void insertData(String username, String number)
    {
        SQLiteDatabase sd=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("username",username);
        cv.put("number",number);
        sd.insert("user",null,cv);

    }

    public Cursor getData()
    {
        SQLiteDatabase sd= this.getReadableDatabase();
        Cursor c=sd.rawQuery("select*from user",null);
        return c;
    }
}
