package com.qlnsitsol.demo.DTO;

public class KyluatDTO {
    private String date;
    private long nhanvienid;
    private String hinhthuckyluat;
    private String lyDo;
    private String tienPhat;
    private  String ngayPhat;

    public KyluatDTO() {
    }

    public KyluatDTO(String date, long nhanvienid, String hinhthuckyluat, String lyDo, String tienPhat, String ngayPhat) {
        this.date = date;
        this.nhanvienid = nhanvienid;
        this.hinhthuckyluat = hinhthuckyluat;
        this.lyDo = lyDo;
        this.tienPhat = tienPhat;
        this.ngayPhat = ngayPhat;
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

    public String getHinhthuckyluat() {
        return hinhthuckyluat;
    }

    public void setHinhthuckyluat(String hinhthuckyluat) {
        this.hinhthuckyluat = hinhthuckyluat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(String tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getNgayPhat() {
        return ngayPhat;
    }

    public void setNgayPhat(String ngayPhat) {
        this.ngayPhat = ngayPhat;
    }
}
