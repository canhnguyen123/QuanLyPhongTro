package com.example.quanlyduan.Model;

public class HopDong {
    private String tenKhachThue, giaThue, tienCoc, ngayBatDau,ngayHetHan;

    public HopDong() {
    }

    public HopDong(String tenKhachThue, String giaThue, String tienCoc, String ngayBatDau, String ngayHetHan) {
        this.tenKhachThue = tenKhachThue;
        this.giaThue = giaThue;
        this.tienCoc = tienCoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayHetHan = ngayHetHan;
    }

    public String getTenKhachThue() {
        return tenKhachThue;
    }

    public void setTenKhachThue(String tenKhachThue) {
        this.tenKhachThue = tenKhachThue;
    }

    public String getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(String giaThue) {
        this.giaThue = giaThue;
    }

    public String getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(String tienCoc) {
        this.tienCoc = tienCoc;
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
}
