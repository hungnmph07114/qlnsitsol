package com.qlnsitsol.demo.DTO;

public class DiemDanhDTO {
    private String date;
    private boolean dilam;
    private long nhanvienid;

    public DiemDanhDTO(String date, boolean dilam, long nhanvienid) {
        this.date = date;
        this.dilam = dilam;
        this.nhanvienid = nhanvienid;
    }

    public DiemDanhDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDilam() {
        return dilam;
    }

    public void setDilam(boolean dilam) {
        this.dilam = dilam;
    }

    public long getNhanvienid() {
        return nhanvienid;
    }

    public void setNhanvienid(long idnhanvien) {
        this.nhanvienid = idnhanvien;
    }
}
