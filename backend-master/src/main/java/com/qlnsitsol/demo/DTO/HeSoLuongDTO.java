package com.qlnsitsol.demo.DTO;

import javax.persistence.Column;

public class HeSoLuongDTO {
    private String date;
    private long nhanvienid;
    private String NgayDieuChinhLuong;
    private String heSoLuong;

    public HeSoLuongDTO() {
    }

    public HeSoLuongDTO(String date, long nhanvienid, String ngayDieuChinhLuong, String heSoLuong) {
        this.date = date;
        this.nhanvienid = nhanvienid;
        this.NgayDieuChinhLuong = ngayDieuChinhLuong;
        this.heSoLuong = heSoLuong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getNhanvienid() {
        return nhanvienid;
    }

    public void setNhanvienid(long nhanvienid) {
        this.nhanvienid = nhanvienid;
    }

    public String getNgayDieuChinhLuong() {
        return this.NgayDieuChinhLuong;
    }

    public void setNgayDieuChinhLuong(String ngayDieuChinhLuong) {
        this.NgayDieuChinhLuong = ngayDieuChinhLuong;
    }

    public String getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(String heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
}
