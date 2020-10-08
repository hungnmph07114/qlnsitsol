package com.qlnsitsol.demo.DTO;

public class PhuCapDTO {
    private String date;
    private long nhanvienid;
    private String tienPhuCap;
    private String ngayPhuCap;

    public PhuCapDTO() {
    }

    public PhuCapDTO(String date, long nhanvienid, String tienPhuCap, String ngayPhuCap) {
        this.date = date;
        this.nhanvienid = nhanvienid;
        this.tienPhuCap = tienPhuCap;
        this.ngayPhuCap = ngayPhuCap;
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

    public String getTienPhuCap() {
        return tienPhuCap;
    }

    public void setTienPhuCap(String tienPhuCap) {
        this.tienPhuCap = tienPhuCap;
    }

    public String getNgayPhuCap() {
        return ngayPhuCap;
    }

    public void setNgayPhuCap(String ngayPhuCap) {
        this.ngayPhuCap = ngayPhuCap;
    }
}
