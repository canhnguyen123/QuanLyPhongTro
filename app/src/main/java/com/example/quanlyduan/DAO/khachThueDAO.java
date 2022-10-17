package com.example.quanlyduan.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyduan.Model.khachThue;
import com.example.quanlyduan.database.DbHelper;

import java.util.ArrayList;

public class khachThueDAO{
    DbHelper helper;
    public  khachThueDAO(Context context){
        helper=new DbHelper(context);
    }
    public ArrayList<khachThue> getALL(){
        // đọc dữ liệu
        SQLiteDatabase db=helper.getReadableDatabase();
        String sql="select*from phongtro";
        Cursor cs=db.rawQuery(sql,null);
        cs.moveToFirst();
        while (cs.isAfterLast()==false){
            int sophong=cs.getInt(0);
            String hoten=cs.getString(1);
            Boolean trangthai= Boolean.valueOf(cs.getString(2));
            int songuoi=cs.getInt(3);
            khachThue kh = new khachThue(sophong,hoten,songuoi,trangthai);

        }
        return  null;
    }
}
