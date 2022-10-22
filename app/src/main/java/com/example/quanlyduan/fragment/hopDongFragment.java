package com.example.quanlyduan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlyduan.DAO.hopDong_DAO;
import com.example.quanlyduan.DAO.phong_troDAO;
import com.example.quanlyduan.Model.HopDong;
import com.example.quanlyduan.Model.phong;
import com.example.quanlyduan.R;
import com.example.quanlyduan.adapter.hopDong_adapter;
import com.example.quanlyduan.adapter.phongtro_apdter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class hopDongFragment extends Fragment {
    FloatingActionButton fab;
    Button btn_them_HD, btn_huy_HD, btn_update_HD, btn_huyUpdate_HD;
    TextView txt_errTenKhach, txt_errGiaThue, txt_errTienCoc;
    EditText ed_TenKhach_HD, ed_giaThue_HD, ed_tienCoc_HD;
    hopDong_DAO dao;
    hopDong_adapter apdter;
    ArrayList<HopDong> list = new ArrayList<>();
    RecyclerView rec;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rec = view.findViewById(R.id.rec_HopDong);
        apdter = new hopDong_adapter(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(layoutManager);
        rec.setAdapter(apdter);
        fab = view.findViewById(R.id.fab_addHopDong);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getContext());
            }
        });


    }

    private void openDialogUpdate(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_update_hopdong, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        btn_update_HD = view.findViewById(R.id.btn_update_HD);
        btn_huyUpdate_HD = view.findViewById(R.id.btn_huyUpdate_HD);
        btn_update_HD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btn_huyUpdate_HD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    private void openDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_hopdong, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        txt_errTenKhach = view.findViewById(R.id.txt_errTenKhach);
        txt_errGiaThue = view.findViewById(R.id.txt_errGiaThue);
        txt_errTienCoc = view.findViewById(R.id.txt_errTienCoc);
        ed_TenKhach_HD = view.findViewById(R.id.ed_TenKhach_HD);
        ed_giaThue_HD = view.findViewById(R.id.ed_giaThue_HD);
        ed_tienCoc_HD = view.findViewById(R.id.ed_tienCoc_HD);
        btn_them_HD = view.findViewById(R.id.btn_them_HD);
        btn_huy_HD = view.findViewById(R.id.btn_huy_HD);

//----------------------------------        
        btn_them_HD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int giaThue = 0, tienCoc = 0;
                String ngayBD = null, ngayKT = null;
                String tenKhach = ed_TenKhach_HD.getText().toString();
                Boolean checkHD = true;

                if (ed_TenKhach_HD.length() == 0) {
                    txt_errTenKhach.setText("Tên không được để trống");
                    checkHD = false;
                }
//-------------------------------
                try {
                    giaThue = Integer.parseInt((ed_giaThue_HD.getText().toString()));

                    if (giaThue < 0) {
                        txt_errGiaThue.setText(" Giá thuê Không được nhỏ hơn 0 ");
                        checkHD = false;
                    }
                } catch (Exception e) {
                    txt_errGiaThue.setText("Giá phải là số và không được để trống");
                    checkHD = false;
                }
//-------------------------------
                try {
                    tienCoc = Integer.parseInt((ed_tienCoc_HD.getText().toString()));

                    if (tienCoc < 0) {
                        txt_errTienCoc.setText(" Tiền cọc Không được nhỏ hơn 0 ");
                        checkHD = false;
                    }
                } catch (Exception e) {
                    txt_errTienCoc.setText("Tiền cọc là số và không được để trống");
                    checkHD = false;
                }

//-------------------------------
                if (checkHD == true) {
                    //  if((dao.insert(sophong,name,sophong,chktt.isSelected()))==true){
                    Toast.makeText(context, "thêm mới thành công", Toast.LENGTH_SHORT).show();
                    HopDong hd = new HopDong(tenKhach, ngayBD, ngayKT, giaThue, tienCoc);
                    list.add(hd);
                    apdter = new hopDong_adapter(getContext(), list);
                    rec.setAdapter(apdter);
                    dialog.dismiss();

                }
            }
        });

        btn_huy_HD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hop_dong, container, false);
    }
}