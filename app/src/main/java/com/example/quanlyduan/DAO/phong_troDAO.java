package com.example.quanlyduan.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyduan.Model.phong;
import com.example.quanlyduan.database.DbHelper;

import java.util.ArrayList;

public class phong_troDAO {
    DbHelper helper;
    public phong_troDAO(Context context){
        helper=new DbHelper(context);
    }
    public ArrayList<phong> getALL(){
        // đọc dữ liệu
        ArrayList<phong> phongs =new ArrayList<>();
        SQLiteDatabase db=helper.getReadableDatabase();
        String sql="select * from phongtro";
        Cursor cs=db.rawQuery(sql,null);
        cs.moveToFirst();
        if(cs.getCount()>0){
            while (!cs.isAfterLast()){
                int sophong=cs.getInt(0);
                String hoten=cs.getString(1);

                boolean trangthai;
                if(cs.getString(2).equals("true")==true)
                {
                    trangthai = true;
                }else {
                    trangthai = false;
                }
                int songuoi=cs.getInt(3);
                phong ph_ = new phong(sophong,hoten,songuoi,trangthai);
                phongs.add(ph_);
                cs.moveToNext();
            }
            cs.close();
        }
        return phongs;
    }
    public boolean insert(int sophong,String hoTen,int soNguoi,boolean trangThai){
        SQLiteDatabase db= helper.getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put("sophong",sophong);
        values.put("hoten",hoTen);
        values.put("songuoio",soNguoi);
        values.put("trangthai",trangThai);
        long row =db.insert("phongtro",null,values);
        return (row>0);
    }
    public boolean insert_(phong phong){
        SQLiteDatabase db= helper.getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put("sophong",phong.getSoPhong());
        values.put("hoten",phong.getHoTen());
        values.put("songuoio",phong.getSoNguoi());
        values.put("trangthai",phong.trangthai());
        long row =db.insert("phongtro",null,values);

        return (row>0);
    }
}
