package com.example.quanlyduan.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyduan.DAO.phong_troDAO;
import com.example.quanlyduan.Model.phong;
import com.example.quanlyduan.R;

import java.util.ArrayList;

public class phongtro_apdter extends RecyclerView.Adapter<phongtro_apdter.phongtroViewHoder> {
    Context context;
    ArrayList<phong>list;
    phong_troDAO dao;

    public phongtro_apdter(Context context, ArrayList<phong> list) {
        this.context = context;
        this.list = list;
        dao=new phong_troDAO(context);
    }

    @NonNull
    @Override
    public phongtroViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater l=((Activity)context).getLayoutInflater();
        View view =l.inflate(R.layout.item_phong,parent,false);
        phongtroViewHoder v = new phongtroViewHoder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull phongtroViewHoder holder, int position) {
        phong p =list.get(position);
        holder.txtsophong.setText(p.getSoPhong()+"");
        holder.ivupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(dao);
            }
        });
        holder.ivdelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(dao);
            }
        });
        holder.ivdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail(dao);
            }
        });
    }
    public  void detail(phong_troDAO dao){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view =inflater.inflate(R.layout.detail,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
    }
    public  void update(phong_troDAO dao){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_updatephong,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        Button btnhuy=view.findViewById(R.id.huy_phong);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public  void  delete(phong_troDAO dao){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_xoaphong,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        Button btnhuy=view.findViewById(R.id.huy_phong);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class phongtroViewHoder extends RecyclerView.ViewHolder{
        TextView txtsophong;
        ImageView ivupdate,ivdelet,ivdetail;
        CardView cav;
        public phongtroViewHoder(@NonNull View view) {
            super(view);
            txtsophong=view.findViewById(R.id.txtphong);
            ivupdate=view.findViewById(R.id.update_phong);
            ivdelet=view.findViewById(R.id.delete_phong);
            cav=view.findViewById(R.id.cardview_phong);
            ivdetail=view.findViewById(R.id.detail);
        }
    }
}
