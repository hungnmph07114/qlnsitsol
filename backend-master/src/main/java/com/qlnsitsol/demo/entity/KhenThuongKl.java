package com.qlnsitsol.demo.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "khenthuong")
public class KhenThuongKl {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;

    @Column(name = "hinhthuc")
    private String HinhThuc;
    @Column(name = "sotien")
    private String SoTien;
    @Column(name = "noidung")
    private String NoiDung;
    @OneToMany(mappedBy = "khenThuongKl", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @NotFound(action = NotFoundAction.IGNORE)
    List<Luong> luongs;

    public KhenThuongKl() {

    }


    public KhenThuongKl(long id, String hinhThuc, String soTien, String noiDung,List<Luong> luongs)  {
        Id = id;
        HinhThuc = hinhThuc;
        SoTien = soTien;
        NoiDung = noiDung;
        this.luongs = luongs;
    }


//    public List<Luong> getLuongs() {
//        return luongs;
//    }

    public void setLuongs(List<Luong> luongs) {
        this.luongs = luongs;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getHinhThuc() {
        return HinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        HinhThuc = hinhThuc;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
