package com.qlnsitsol.demo.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DiemDanhId implements Serializable {
    @Column(name = "date")
    private String date;
    @ManyToOne
    @JoinColumn(name ="nhanvienid",referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private NhanVien nhanVien;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiemDanhId)) return false;
        DiemDanhId that = (DiemDanhId) o;
        return getDate().equals(that.getDate()) &&
                getNhanVien().equals(that.getNhanVien());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getNhanVien());
    }
}
