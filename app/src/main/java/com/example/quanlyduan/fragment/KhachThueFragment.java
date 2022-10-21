package com.example.quanlyduan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlyduan.Adapter.KhachThueAdapter;
import com.example.quanlyduan.DAO.KhachThueDAO;
import com.example.quanlyduan.Model.KhachThue;
import com.example.quanlyduan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class KhachThueFragment extends Fragment {
    KhachThue item;
    KhachThueAdapter adapter;
    static KhachThueDAO dao;
    ListView lv;
    ArrayList<KhachThue> list;
    FloatingActionButton fab;
    Dialog dialog;
    EditText edId ,edhoTen,edSdt,edCccd , edSoPhong;
    Button btnSave, btnCancel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_khach_thue,container, false);
        lv = v.findViewById(R.id.lvKhachThue);
        fab = v.findViewById(R.id.fab);

        dao = new KhachThueDAO(getActivity());
        capNhatLV();
        fab.setOnClickListener(v1 -> {
            openDialog(getActivity(),0);

            lv.setOnItemClickListener(((parent, view, position, id) -> {
                item = list.get(position);

                return;
            }));
        });
        return v;
    }

    protected void openDialog(final Context context, final  int type){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.khachthue_dialog);
        edId = dialog.findViewById(R.id.edId);
        edhoTen = dialog.findViewById(R.id.edTenKT);
        edSdt = dialog.findViewById(R.id.edSdt);
        edCccd = dialog.findViewById(R.id.edCccd);
        edSoPhong = dialog.findViewById(R.id.edSoPhong);

        btnSave = dialog.findViewById(R.id.btnSave);
        btnCancel = dialog.findViewById(R.id.btnCancel);

        if (type != 0){
            edId.setText(String.valueOf(item.Id));
            edhoTen.setText(item.Id);
            edSdt.setText(String.valueOf(item.Sdt));
            edCccd.setText(String.valueOf(item.Cccd));
            edSoPhong.setText(item.SoPhong);
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = new KhachThue();
                item.Id = Integer.parseInt(edId.getText().toString());
                item.hoTen = edhoTen.getText().toString();
                item.Sdt = Integer.parseInt(edSdt.getText().toString());
                item.Cccd = Integer.parseInt(edCccd.getText().toString());
                item.SoPhong = edSoPhong.getText().toString();

                if (validate() > 0){
                    if (type == 0){
                        if (dao.insert(item) > 0){
                            Toast.makeText(context, "Thêm thành công !!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Thêm thất bại !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        item.Id = Integer.parseInt(edId.getText().toString());
                        if (dao.update(item) > 0){
                            Toast.makeText(context, "Sửa thành công !!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Sửa thất bại !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    capNhatLV();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void update(){
        openDialog(getContext(),0);
    }

    public void xoa(final String id ){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xóa khách thuê !!");
        builder.setMessage("Bạn có muốn xóa khách thuê này không ?");
        builder.setCancelable(true);
        builder.setPositiveButton(" < Yes > ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.delete(id);
                capNhatLV();
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        builder.show();
    }

    void capNhatLV(){
        list = (ArrayList<KhachThue>) dao.getAll();
        adapter = new KhachThueAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
    }

    private  int validate(){
        int check = 1;
        if (edId.getText().length() == 0 ){
            Toast.makeText(getContext(), "Bạn phải nhập đủ thông tin khách hàng", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}