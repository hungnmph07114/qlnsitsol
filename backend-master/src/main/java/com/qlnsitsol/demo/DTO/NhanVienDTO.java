package com.qlnsitsol.demo.DTO;

import com.qlnsitsol.demo.entity.NhanVien;

public class NhanVienDTO {
    private String tenNhanVien;
    private String ngaySinh;
    private String soCmnnd;
    private String SoTienKhenThuong;
    private String KhoanCong;
    private String KhoanTru;
    private String LuongCoBan;
    private String thang;
    private String tongCong;

    public NhanVienDTO toDTO(NhanVien nv) {
        NhanVienDTO dto = new NhanVienDTO();
        dto.setTenNhanVien(nv.getTenNhanVien());
        dto.setNgaySinh(nv.getNgaySinh());
        dto.setSoCmnnd(nv.getSoCmnnd());
//        dto.setSoTienKhenThuong();
//        dto.setKhoanCong(nv.getLuongs().get(0).getKhoanCong());
//        dto.setKhoanTru(nv.getTenNhanVien());
//        dto.setLuongCoBan(nv.getChuVu());
//        dto.setThang(nv.getPhongBan().getGhiChu());
        return dto;

    }

    public NhanVienDTO() {
    }

    public NhanVienDTO(String tenNhanVien, String ngaySinh, String soCmnnd, String soTienKhenThuong, String khoanCong, String khoanTru, String luongCoBan, String thang) {
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.soCmnnd = soCmnnd;
        SoTienKhenThuong = soTienKhenThuong;
        KhoanCong = khoanCong;
        KhoanTru = khoanTru;
        LuongCoBan = luongCoBan;
        this.thang = thang;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCmnnd() {
        return soCmnnd;
    }

    public void setSoCmnnd(String soCmnnd) {
        this.soCmnnd = soCmnnd;
    }

    public String getSoTienKhenThuong() {
        return SoTienKhenThuong;
    }

    public void setSoTienKhenThuong(String soTienKhenThuong) {
        SoTienKhenThuong = soTienKhenThuong;
    }

    public String getKhoanCong() {
        return KhoanCong;
    }

    public void setKhoanCong(String khoanCong) {
        KhoanCong = khoanCong;
    }

    public String getKhoanTru() {
        return KhoanTru;
    }

    public void setKhoanTru(String khoanTru) {
        KhoanTru = khoanTru;
    }

    public String getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(String luongCoBan) {
        LuongCoBan = luongCoBan;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getTongCong() {
        return tongCong;
    }

    public void setTongCong(String tongCong) {
        this.tongCong = tongCong;
    }
}
