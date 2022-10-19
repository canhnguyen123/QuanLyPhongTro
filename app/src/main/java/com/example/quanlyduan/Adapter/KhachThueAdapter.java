package com.example.quanlyduan.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlyduan.Model.KhachThue;
import com.example.quanlyduan.R;
import com.example.quanlyduan.fragment.KhachThueFragment;

import java.util.ArrayList;

public class KhachThueAdapter extends ArrayAdapter<KhachThue> {
    private Context context;
    KhachThueFragment fragment;
    private ArrayList<KhachThue> lists;
    TextView tvTenKhachThue, tvSoPhong;
    ImageView imgXoa, imgSua;

    public KhachThueAdapter(@NonNull Context context, KhachThueFragment fragment, ArrayList<KhachThue> lists) {
        super(context, 0, lists);
        this.context = context;
        this.lists = lists;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.khachthue_item,null);
        }

        final KhachThue item = lists.get(position);
        if (item != null){
            tvTenKhachThue = v.findViewById(R.id.tvTenKT);
            tvTenKhachThue.setText("Tên Khách Thuê: " +item.hoTen);
            tvSoPhong = v.findViewById(R.id.tvSoPhong);
            tvSoPhong.setText("Số Phòng :" +item.SoPhong);

            imgXoa = v.findViewById(R.id.imgXoaKT);
            imgXoa.setOnClickListener(v1 -> {
                fragment.xoa(String.valueOf(item.Id));
            });

            imgSua= v.findViewById(R.id.imgUpdate);
            imgSua.setOnClickListener(v1 -> {
                fragment.update();
            });

            tvTenKhachThue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Thông tin khách thuê " );
                    builder.setMessage("Id phòng :" +lists.get(item.Id) + "\n"
                            + "Họ Tên :" +tvTenKhachThue.getText().toString() + "\n"+
                             "Số điện thoại :" + lists.get(item.Sdt) + "\n" +
                            "Căn cước công dân :" + lists.get(item.getCccd()) + "\n" +
                            "Số phòng :" + item.SoPhong );
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Xem xong rồi hả , hơi lâu đó !!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog a =builder.create();
                    a.show();
                }
            });
        }
        return v;
    }
}
