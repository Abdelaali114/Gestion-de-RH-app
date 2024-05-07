package com.example.login_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context Context){
        super(Context,"signup.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("Create Table users(username Text Primary Key , email Email, password password, Confirm_password password  )");
        mydb.execSQL("Create Table employeurs(name Text Primary Key , email Email, age Text, Gender Text,Post Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldVersion, int newVersion) {
        mydb.execSQL("drop Table if exists users");
        mydb.execSQL("drop Table if exists employeurs");
    }
    public boolean insertusersdb(String username, String email, String password, String confirm_password) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put("username",username);
        ContentValues.put("email",email);
        ContentValues.put("password",password);
        ContentValues.put("confirm_password",confirm_password);
        long resultat= mydb.insert("users",null,ContentValues);
        if (resultat==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkusername(String username2){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from users where username=? ", new String[] {username2});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean emptyspacecheck(String username1 , String password1){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from users where username=? and password=?", new String[] {username1,password1});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    /////////////////////////
    public boolean insertemployeursdb(String name, String email, String age, String Gender, String Post) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put("name",name);
        ContentValues.put("email",email);
        ContentValues.put("age",age);
        ContentValues.put("Gender",Gender);
        ContentValues.put("Post",Post);
        long resultat= mydb.insert("employeurs",null,ContentValues);
        if (resultat==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
