package com.example.quanlyduan.Model;

public class phong {
    private int soPhong;
    private String hoTen;
    private int soNguoi;
    private boolean trangThai;

    public phong() {
    }

    public phong(int soPhong, String hoTen, int soNguoi, boolean trangThai) {
        this.soPhong = soPhong;
        this.hoTen = hoTen;
        this.soNguoi = soNguoi;
        this.trangThai = trangThai;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String trangthai() { //s
        if (trangThai == true) {
            return "còn phòng";
        } else {
            return "hết phòng";
        }
    }
}
