package com.example.quanlyduan.Model;

public class KhachThue {
    public int Id;
    public String hoTen;
    public int Sdt;
    public int Cccd;
    public String SoPhong;

    public KhachThue() {
    }

    public KhachThue(int id, String hoTen, int sdt, int cccd, String soPhong) {
        Id = id;
        this.hoTen = hoTen;
        Sdt = sdt;
        Cccd = cccd;
        SoPhong = soPhong;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int sdt) {
        Sdt = sdt;
    }

    public int getCccd() {
        return Cccd;
    }

    public void setCccd(int cccd) {
        Cccd = cccd;
    }

    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String soPhong) {
        SoPhong = soPhong;
    }
}
