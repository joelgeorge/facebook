package com.joelgeorge.facebooksqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by PAUL GEORGE on 6/22/2016.
 */
public class MysqliteHelper extends SQLiteOpenHelper {


    public MysqliteHelper(Context context) {
        super(context,"signupdb",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table tbl_signup(id integer primary key autoincrement,name text,day text,month text,year text,password text)");
        }catch (SQLiteException e) {
            Log.d("error in creating table",e.getLocalizedMessage().toString());}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbl_signup");
        onCreate(db);
    }
    public boolean insertdata(String name,String day,String month,String year,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long result=-1,second=-1;
        ContentValues mycontent=new ContentValues();
        mycontent.put("name", name);
        mycontent.put("day",day);
        mycontent.put("month",month);
        mycontent.put("year",year);
        mycontent.put("password",password);
        try{
            result=db.insert("tbl_signup", null, mycontent);
        }
        catch(SQLiteException e)
        {
            Log.d("message",e.getLocalizedMessage().toString());
        }


        if(result==-1 && second==-1)
        {
            return false;
        }
        else
        {
            return true;
        }




    }
    public String getdata(String userName) {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query("tbl_signup", null, "name=?",
                new String[] { userName }, null, null, null);

        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;


    }
    public Cursor getalldata()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from tbl_signup",null);
        return res;

    }




}
