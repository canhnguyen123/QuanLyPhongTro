package com.example.quanlyduan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static final String dbname = "QLPT";

    public DbHelper(@Nullable Context context) {
        super(context,dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table phongtro(sophong integer primary key,"+
                " hoten text,songuoio int,trangthai boolean)";
        db.execSQL(sql );


        String createTableKhachThue = " create table KhachThue (" +
                "Id INTEGER PRIMARY KEY," +
                "hoTen TEXT NOT NULL," +
                "Sdt INTERGER NOT NULL," +
                "Cccd INTERGER NOT NULL," +
                "SoPhong TEXT )";
        db.execSQL(createTableKhachThue);


        String createTable = " create table KhachThue (" +
                "Id INTEGER PRIMARY KEY," +
                "hoTen TEXT NOT NULL," +
                "Sdt INTERGER NOT NULL," +
                "Cccd INTERGER NOT NULL," +
                "SoPhong TEXT )";
        db.execSQL(createTableKhachThue);



        String createTabletsf = " create table KhachThue (" +
                "Id INTEGER PRIMARY KEY," +
                "hoTen TEXT NOT NULL," +
                "Sdt INTERGER NOT NULL," +
                "Cccd INTERGER NOT NULL," +
                "SoPhong TEXT )";
        db.execSQL(createTableKhachThue);



    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists phongtro");
            onCreate(db);
        String dropTableKhachThue = "drop table if exists KhachThue";
        db.execSQL(dropTableKhachThue);
    }


}
