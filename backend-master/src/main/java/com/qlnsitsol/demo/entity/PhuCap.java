package com.qlnsitsol.demo.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phucap")
public class PhuCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String tienPhuCap;
    private String ngayPhuCap;

    @OneToMany(mappedBy = "phuCap", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @NotFound(action = NotFoundAction.IGNORE)
    List<Luong> luongs;


    public PhuCap() {

    }

    public PhuCap(long id, String tienPhuCap, String ngayPhuCap) {
        this.id = id;
        this.tienPhuCap = tienPhuCap;
        this.ngayPhuCap = ngayPhuCap;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public void setLuongs(List<Luong> luongs) {
        this.luongs = luongs;
    }
}
