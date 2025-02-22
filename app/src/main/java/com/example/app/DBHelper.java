package com.example.app;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER (username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUser(String username, String password){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues cv =new ContentValues();
        cv.put("username", username);
        cv.put("password", password);

        long rowID = db.insert("USER", null, cv);

        if(rowID == -1) // an error has occurred
            return false;
        else
            return true;
    }

    public boolean userExists (String username){
        SQLiteDatabase db =this.getWritableDatabase(); //we might put it as readable
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE username=?",
                new String[]{username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkUsernamePassword (String username, String password){
        SQLiteDatabase db =this.getWritableDatabase(); //we might put it as readable
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE username=? AND password=?",
                new String[]{username, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean updateUsernamePassword (String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("UPDATE USER SET username = ?, password = ? WHERE username = ?", new String[]{username, password, OnLogin.user});
        if(cursor.getCount() > 0)
            return false;
        else
            return true;
    }

//    public  boolean deleteAccount (String username){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("DELETE FROM USER WHERE username = ?", new String[]{OnLogin.user});
//        if(cursor.getCount() > 0)
//            return false;
//        else
//            return true;
//    }
}
