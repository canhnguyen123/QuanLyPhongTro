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
                    txtloiten.setText("T??n kh??ng ???????c ????? tr???ng");
                    check=false;
                }

                try {
                    songuoio=Integer.parseInt((editsonguoio.getText().toString()));

                    if(songuoio<0){
                        txtloingo.setText(" s??? ng?????i ??? Kh??ng ???????c nh??? h??n 0 ");
                        check=false;
                    }
                    if(songuoio>5){
                        txtloingo.setText(" s??? ng?????i ??? Kh??ng ???????c l???n h??n 5 ");
                        check=false;
                    }
                }catch (Exception e){
                    txtloingo.setText("S??? ng?????i ??? ph???i l?? s??? v?? kh??ng ???????c ????? tr???ng");
                    check=false;
                }
                try {
                    sophong=Integer.parseInt((editsophong.getText().toString()));

                    if(sophong<0){
                        txtloiphong.setText(" s??? phong ??? Kh??ng ???????c nh??? h??n 0 ");
                        check=false;
                    }
                    if(sophong>999){
                        txtloiphong.setText(" s??? ph??ng ??? Kh??ng ???????c l???n h??n 999 ");
                        check=false;
                    }
                }catch (Exception e){
                    txtloiphong.setText("S??? ph??ng ??? ph???i l?? s??? v?? kh??ng ???????c ????? tr???ng");
                    check=false;
                }


//                boolean tinhtrang = chktt.isSelected();
                if(check==true){
                    //  if((dao.insert(sophong,name,sophong,chktt.isSelected()))==true){
                    Toast.makeText(context,"th??m m???i th??nh c??ng",Toast.LENGTH_SHORT).show();
                    phong ph = new phong(sophong,name,sophong,chktt.isSelected());
                    list.add(ph);
                    apdter = new phongtro_apdter(getContext(),list);
                    rec.setAdapter(apdter);
                    dialog.dismiss();
//                        list.clear();
                    // list=dao.getALL();
//                        apdter.notifyDataSetChanged();
                    /// }else {Toast.makeText(context,"th??m m???i k th??nh c??ng",Toast.LENGTH_SHORT).show();

                    //}//n?? ??ang b??o k th???y apdter s???a c??i ?????y trc ???? sql, s???a s a u tu tu ?????y l?? do b??? l???i m???y ph???n n??y n??n layout vs adapter b??? gi???t n??n ???ng d???ng l???i ch??? t?? ??i mua ????? ??n r???i t??i l??m l???i cho b???n c??i sql ko th?? b???n s??i Firebase cx ??c
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