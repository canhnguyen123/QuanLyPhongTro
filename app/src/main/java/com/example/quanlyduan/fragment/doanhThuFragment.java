package com.example.quanlyduan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quanlyduan.Activity.DoanhThuNamActivity;
import com.example.quanlyduan.Activity.DoanhThuThangActivity;
import com.example.quanlyduan.R;

public class doanhThuFragment extends Fragment {
    private TextView tv_DoanhThuThang, tv_DoanhThuNam;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_DoanhThuThang = view.findViewById(R.id.tv_DoanhThuThang);
        tv_DoanhThuNam = view.findViewById(R.id.tv_DoanhThuNam);

        tv_DoanhThuThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DoanhThuThangActivity.class);
                startActivity(intent);
            }
        });

        tv_DoanhThuNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DoanhThuNamActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doanh_thu, container, false);
    }
}