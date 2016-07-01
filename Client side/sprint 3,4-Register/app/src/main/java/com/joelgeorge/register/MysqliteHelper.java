package com.joelgeorge.register;

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
        super(context,"studentdb",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table tbl_student(id integer primary key autoincrement,name text)");
        }catch (SQLiteException e) {
            Log.d("error in creating table",e.getLocalizedMessage().toString());}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbl_student");
        onCreate(db);
    }
    public boolean insertdata(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long result=-1,second=-1;
        ContentValues mycontent=new ContentValues();
        mycontent.put("name", name);
        try{
            result=db.insert("tbl_student", null, mycontent);
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
public Cursor getalldata()
{
    SQLiteDatabase db =this.getWritableDatabase();
    Cursor res=db.rawQuery("select * from tbl_student",null);
return res;

}





}
