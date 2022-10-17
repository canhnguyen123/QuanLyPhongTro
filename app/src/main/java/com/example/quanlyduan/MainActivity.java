package com.example.quanlyduan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlyduan.fragment.phongtro_Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar_);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HOME");
        // Kết Thúc Xử Lí Toolbar
        // ánh xạ drawer vs navigation
        drawerLayout = findViewById(R.id.Draw_layout);
        navigationView = findViewById(R.id.Draw_nav);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_main,new phongtro_Fragment()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_phongtro:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new phongtro_Fragment()).commit();
                        getSupportActionBar().setTitle("Quản Lý Phong Tro");
                        break;
                    case R.id.nav_dichvu:
                        Toast.makeText(getBaseContext(),"Dich Vu",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_hoadon:
                        
                        break;

                }
                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home )
        {
            drawerLayout.openDrawer(navigationView);

        }

        return super.onOptionsItemSelected(item);
    }



}