package com.qlnsitsol.demo.DTO;


import com.qlnsitsol.demo.entity.NhanVien;

import javax.persistence.Column;
import javax.validation.constraints.Min;

public class CreNhanVienDTO {
    private  long id;
    private String tenNhanVien;
    private String ngaySinh;
    private Boolean gioiTinh;
    private String diaChi;
    @Min(10)
    private String soCmnnd;
    private String dienThoai;
    private String chuVu;
    private String email;
    private String img;
    private Boolean action;
    @Column(name = "ngaybatdau")
    private String ngayBatDau;
    @Column(name = "ngayketthuc")
    private String ngayKetThuc;
    private long phongbanid;

    public CreNhanVienDTO() {
    }

    public NhanVien toEntity(CreNhanVienDTO dto){
        NhanVien nv = new NhanVien();
        nv.setAction(dto.getAction());
        nv.setTenNhanVien(dto.getTenNhanVien());
        nv.setNgaySinh(dto.getNgaySinh());
        nv.setGioiTinh(dto.getGioiTinh());
        nv.setDiaChi(dto.getDiaChi());
        nv.setSoCmnnd(dto.getSoCmnnd());
        nv.setDienThoai(dto.getDienThoai());
        nv.setChuVu(dto.getChuVu());
        nv.setEmail(dto.getEmail());
        nv.setImg(dto.getImg());
        nv.setNgayBatDau(dto.getNgayBatDau());
        nv.setNgayKetThuc(dto.getNgayKetThuc());
        return nv;
    }

    public CreNhanVienDTO(String tenNhanVien, String ngaySinh, Boolean gioiTinh, String diaChi, @Min(10) String soCmnnd, String dienThoai, String chuVu, String email, String img, Boolean action, long phongbanid) {
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soCmnnd = soCmnnd;
        this.dienThoai = dienThoai;
        this.chuVu = chuVu;
        this.email = email;
        this.img = img;
        this.action = action;
        this.phongbanid = phongbanid;
    }

    public long getPhongbanid() {
        return phongbanid;
    }

    public void setPhongbanid(long phongbanid) {
        this.phongbanid = phongbanid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
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

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoCmnnd() {
        return soCmnnd;
    }

    public void setSoCmnnd(String soCmnnd) {
        this.soCmnnd = soCmnnd;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getChuVu() {
        return chuVu;
    }

    public void setChuVu(String chuVu) {
        this.chuVu = chuVu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getAction() {
        return action;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }
}
