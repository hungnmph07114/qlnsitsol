package com.qlnsitsol.demo.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "tenphongban")
    private String tenPhongBan;
    @Column(name = "dienthoai")
    private String dienThoai;
    @Column(name = "ghichu")
    private String ghiChu;
    private String img;
    @Column(name = "isaction")
    private Boolean action;
//    @OneToMany(mappedBy = "phongBan", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @NotFound(action = NotFoundAction.IGNORE)
//    private List<ChucVu> chucVus;
   @OneToMany(mappedBy = "phongBan", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @NotFound(action = NotFoundAction.IGNORE)
    private List<NhanVien> nhanViens;
    public PhongBan() {
    }
    public PhongBan(long id , String name , String sdt , String ghiChu,String
                    img, Boolean action) {
        this.id = id;
        this.tenPhongBan = name;
        this.dienThoai = sdt;
        this.ghiChu = ghiChu;
        this.img =img;
        this.action = action;
    }

    public Boolean getAction() {
        return action;
    }
    public void setAction(Boolean action) {
        this.action = action;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
