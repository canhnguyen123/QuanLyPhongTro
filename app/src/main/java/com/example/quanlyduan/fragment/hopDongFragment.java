package com.example.quanlyduan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.quanlyduan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class hopDongFragment extends Fragment {
    FloatingActionButton fab;

    //dialog them
    EditText ed_TenKhach_HD, ed_giaThue_HD, ed_tienCoc_HD;
    Spinner spinner_soPhong_HD;
    DatePicker ed_batDau_HD, ed_ketThuc_HD;
    CheckBox chk_dien, chk_nuoc, chk_wifi, chk_VS;
    Button btn_them_HD, btn_huy_HD;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ed_TenKhach_HD = view.findViewById(R.id.ed_TenKhach_HD);
        ed_giaThue_HD = view.findViewById(R.id.ed_giaThue_HD);
        ed_tienCoc_HD = view.findViewById(R.id.ed_tienCoc_HD);
        spinner_soPhong_HD = view.findViewById(R.id.spinner_soPhong_HD);
        ed_batDau_HD = view.findViewById(R.id.ed_batDau_HD);
        ed_ketThuc_HD = view.findViewById(R.id.ed_ketThuc_HD);
        chk_dien = view.findViewById(R.id.chk_dien);
        chk_nuoc = view.findViewById(R.id.chk_nuoc);
        chk_wifi = view.findViewById(R.id.chk_wifi);
        chk_VS = view.findViewById(R.id.chk_VS);
        btn_them_HD = view.findViewById(R.id.btn_them_HD);
        btn_huy_HD = view.findViewById(R.id.btn_huy_HD);
        fab = view.findViewById(R.id.fab_addHopDong);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity());
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hop_dong, container, false);
    }
}