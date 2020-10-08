package com.qlnsitsol.demo.DTO;

public class TamUngDTO {
    private String date;
    private long nhanvienid;
    private String tienTamung;
    private String lyDo;
    private String ngayTamUng;

    public TamUngDTO(String date, long nhanvienid, String tienTamung, String lyDo, String ngayTamUng) {
        this.date = date;
        this.nhanvienid = nhanvienid;
        this.tienTamung = tienTamung;
        this.lyDo = lyDo;
        this.ngayTamUng = ngayTamUng;
    }

    public TamUngDTO() {
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

    public String getTienTamung() {
        return tienTamung;
    }

    public void setTienTamung(String tienTamung) {
        this.tienTamung = tienTamung;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getNgayTamUng() {
        return ngayTamUng;
    }

    public void setNgayTamUng(String ngayTamUng) {
        this.ngayTamUng = ngayTamUng;
    }
}
