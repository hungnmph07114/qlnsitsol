package com.qlnsitsol.demo.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hesoluong")
public class HeSoLuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ngaydieuchinhluong")
    private String NgayDieuChinhLuong;
    @Column(name = "hesoluong")
    private String heSoLuong;
    @OneToMany(mappedBy = "heSoLuong", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @NotFound(action = NotFoundAction.IGNORE)
    List<Luong> luongs;
    public HeSoLuong() {
    }
    public HeSoLuong(long id, String ngayDieuChinhLuong, String heSoLuong) {
        this.id = id;
        NgayDieuChinhLuong = ngayDieuChinhLuong;
        this.heSoLuong = heSoLuong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNgayDieuChinhLuong() {
        return NgayDieuChinhLuong;
    }

    public void setNgayDieuChinhLuong(String ngayDieuChinhLuong) {
        NgayDieuChinhLuong = ngayDieuChinhLuong;
    }

    public String getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(String heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

}
