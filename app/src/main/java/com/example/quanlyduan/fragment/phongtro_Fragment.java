package com.example.quanlyduan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlyduan.DAO.phong_troDAO;
import com.example.quanlyduan.Model.phong;
import com.example.quanlyduan.R;
import com.example.quanlyduan.adapter.phongtro_apdter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class phongtro_Fragment extends Fragment {
    FloatingActionButton fab;
    Button btnadd;
    TextView txtloiten,txtloingo,txtloiphong;
    EditText editten,editsonguoio,editsophong;
    CheckBox chktt;
    phong_troDAO dao;
    phongtro_apdter apdter;
    ArrayList<phong> list= new ArrayList<>();
    RecyclerView rec;
    public phongtro_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab=view.findViewById(R.id.fabaddphong);
        rec = view.findViewById(R.id.recphong);
        apdter = new phongtro_apdter(getContext(),list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(layoutManager);
        rec.setAdapter(apdter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getContext());
            }
        });

        fab = view.findViewById(R.id.fabaddphong);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getContext());
            }
        });
    }

    private  void  openDialog( Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder( context);
        LayoutInflater inflater = this.getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_addphong,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        btnadd=view.findViewById(R.id.btn_add_phong);
        editten=view.findViewById(R.id.edit_addtennguoio);
        editsonguoio=view.findViewById(R.id.eidt_addsonguoio);
        editsophong=view.findViewById(R.id.edit_addsophong);
        chktt=view.findViewById(R.id.chktt);
        txtloiten=view.findViewById(R.id.txtloiten);
        txtloingo=view.findViewById(R.id.loisonguoio);
        txtloiphong=view.findViewById(R.id.loisophong);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                Boolean check=true;
                int songuoio=0,sophong=0;
                String name=editten.getText().toString();
                if(editten.length()==0){
                    txtloiten.setText("Tên không được để trống");
                    check=false;
                }

                try {
                    songuoio=Integer.parseInt((editsonguoio.getText().toString()));

                    if(songuoio<0){
                        txtloingo.setText(" số người ở Không được nhỏ hơn 0 ");
                        check=false;
                    }
                    if(songuoio>5){
                        txtloingo.setText(" số người ở Không được lớn hơn 5 ");
                        check=false;
                    }
                }catch (Exception e){
                    txtloingo.setText("Số ngưởi ở phải là số và không được để trống");
                    check=false;
                }
                try {
                    sophong=Integer.parseInt((editsophong.getText().toString()));

                    if(sophong<0){
                        txtloiphong.setText(" số phong ở Không được nhỏ hơn 0 ");
                        check=false;
                    }
                    if(sophong>999){
                        txtloiphong.setText(" số phòng ở Không được lớn hơn 999 ");
                        check=false;
                    }
                }catch (Exception e){
                    txtloiphong.setText("Số phòng ở phải là số và không được để trống");
                    check=false;
                }


//                boolean tinhtrang = chktt.isSelected();
                if(check==true){
                    //  if((dao.insert(sophong,name,sophong,chktt.isSelected()))==true){
                    Toast.makeText(context,"thêm mới thành công",Toast.LENGTH_SHORT).show();
                    phong ph = new phong(sophong,name,sophong,chktt.isSelected());
                    list.add(ph);
                    apdter = new phongtro_apdter(getContext(),list);
                    rec.setAdapter(apdter);
                    dialog.dismiss();
//                        list.clear();
                    // list=dao.getALL();
//                        apdter.notifyDataSetChanged();
                    /// }else {Toast.makeText(context,"thêm mới k thành công",Toast.LENGTH_SHORT).show();

                    //}//nó đang báo k thấy apdter sửa cái đấy trc đã sql, sửa s a u tu tu đấy là do bị lỗi mấy phần này nên layout vs adapter bị giết nên ứng dụng lỗi chờ tí đi mua đồ ăn rồi tôi làm lại cho bạn cái sql ko thì bạn sài Firebase cx đc
                }
            }
        });

    }
    void reset(){
        txtloingo.setText("");
        txtloiphong.setText("");
        txtloiten.setText("");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_phongtro_, container, false);
        return view;
    }
}