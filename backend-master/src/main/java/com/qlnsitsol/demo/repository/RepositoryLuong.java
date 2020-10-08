package com.qlnsitsol.demo.repository;
import com.qlnsitsol.demo.entity.Luong;
import com.qlnsitsol.demo.entity.LuongId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryLuong extends JpaRepository<Luong, LuongId> {
    List<Luong> getAllById_NhanVien_ActionAndId_Date(Boolean bl,String  date);
    List<Luong> getAllById_NhanVien_Id(long id);
    Boolean existsById_NhanVien_IdAndId_Date(long id,String date);
    boolean existsById_Date(String bl);
}
