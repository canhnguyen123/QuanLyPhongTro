package com.example.quanlyduan.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyduan.DAO.hopDong_DAO;
import com.example.quanlyduan.DAO.phong_troDAO;
import com.example.quanlyduan.Model.HopDong;
import com.example.quanlyduan.R;


import java.util.ArrayList;

public class hopDong_adapter extends RecyclerView.Adapter<hopDong_adapter.hopDongViewHoder> {
    Context context;
    ArrayList<HopDong> list;
    hopDong_DAO dao;

    public hopDong_adapter(Context context, ArrayList<HopDong> list) {
        this.context = context;
        this.list = list;
        dao = new hopDong_DAO(context);
    }

    @NonNull
    @Override
    public hopDongViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater l = ((Activity) context).getLayoutInflater();
        View view = l.inflate(R.layout.item_hop_dong, parent, false);
        hopDongViewHoder v = new hopDongViewHoder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull hopDongViewHoder holder, int position) {
        HopDong hd = list.get(position);
        holder.txt_item_hopDong.setText(hd.getTenKhachThue() + "");
        holder.img_update_hopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(dao);
            }
        });
        holder.img_delete_hopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(dao);
            }
        });
    }

    public  void update(hopDong_DAO dao){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_update_hopdong,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
    }
    public  void  delete(hopDong_DAO dao){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setMessage("Bạn có muốn xóa hợp đồng này không?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Hủy xóa", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class hopDongViewHoder extends RecyclerView.ViewHolder {
        TextView txt_item_hopDong;
        ImageView img_update_hopDong, img_delete_hopDong;
        CardView cav;

        public hopDongViewHoder(@NonNull View view) {
            super(view);
            txt_item_hopDong = view.findViewById(R.id.txt_item_hopDong);
            img_update_hopDong = view.findViewById(R.id.img_update_hopDong);
            img_delete_hopDong = view.findViewById(R.id.img_delete_hopDong);
            cav = view.findViewById(R.id.cardview_hopDong);
        }
    }
}
