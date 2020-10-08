package com.qlnsitsol.demo.DTO;

import com.qlnsitsol.demo.entity.NhanVien;

public class PhongBanDTO {
    private  long id;
    private String TenNV;
    private String TenPB;
    private String chucVu;
    private String ghiChu;
    private String img;
    public PhongBanDTO() {

    }

    public PhongBanDTO(long id,String tenNV, String tenPB, String ghiChu, String img) {
        this.id = id;
        TenNV = tenNV;
        TenPB = tenPB;
        this.ghiChu = ghiChu;
        this.img = img;
    }
    public PhongBanDTO toDTO(NhanVien nv) {
        PhongBanDTO dto = new PhongBanDTO();
        dto.setId(nv.getPhongBan().getId());
        dto.setTenNV(nv.getTenNhanVien());
        dto.setChucVu(nv.getChuVu());
        dto.setGhiChu(nv.getPhongBan().getGhiChu());
        dto.setImg(nv.getPhongBan().getImg());
        dto.setTenPB(nv.getPhongBan().getTenPhongBan());
        return dto;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String tenPB) {
        TenPB = tenPB;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
