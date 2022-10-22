package com.example.quanlyduan.Model;

public class HopDong {
    private String tenKhachThue, ngayBatDau, ngayHetHan;
    private int giaThue, tienCoc;

    public HopDong() {
    }

    public HopDong(String tenKhachThue, String ngayBatDau, String ngayHetHan, int giaThue, int tienCoc) {
        this.tenKhachThue = tenKhachThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayHetHan = ngayHetHan;
        this.giaThue = giaThue;
        this.tienCoc = tienCoc;
    }

    public String getTenKhachThue() {
        return tenKhachThue;
    }

    public void setTenKhachThue(String tenKhachThue) {
        this.tenKhachThue = tenKhachThue;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }
}
