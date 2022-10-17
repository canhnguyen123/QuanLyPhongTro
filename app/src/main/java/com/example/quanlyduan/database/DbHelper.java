package com.example.quanlyduan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context,"duan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table phongtro(sophong integer primary key,"+
                " hoten text,songuoio int,trangthai boolean)";
        db.execSQL(sql );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists phongtro");
            onCreate(db);
    }
}
