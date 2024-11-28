package com.example.comutapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

    public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String databaseName = "SignLog.db";

        public DatabaseHelper(@Nullable Context context) {
            super(context, databaseName, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase MyDatabase) {
            MyDatabase.execSQL("create Table users(email TEXT primary key, password TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
            MyDB.execSQL("drop Table if exists users");
        }

        public Boolean insertData(String email, String password){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("email", email);
            contentValues.put("password", password);
            long result = MyDatabase.insert("users", null, contentValues);


            return result == -1;
        }

        public Boolean checkEmail(String email){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ?", new String[]{email});
            MyDatabase.close();
            return  cursor.getCount() > 0;
        }
        public Boolean checkEmailPassword(String email, String password){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ? and password = ?", new String[]{email, password});
            MyDatabase.close();
            return cursor.getCount() > 0;
        }

    }

