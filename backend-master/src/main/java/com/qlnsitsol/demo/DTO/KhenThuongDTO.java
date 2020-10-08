package com.qlnsitsol.demo.DTO;

public class KhenThuongDTO {
    private String date;
    private long nhanvienid;
    private String hinhthuc;
    private String noidung;
    private String sotien;

    public KhenThuongDTO() {
    }

    public KhenThuongDTO(String date, long nhanvienid, String hinhthuc, String noidung, String sotien) {
        this.date = date;
        this.nhanvienid = nhanvienid;
        this.hinhthuc = hinhthuc;
        this.noidung = noidung;
        this.sotien = sotien;
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

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }
}
