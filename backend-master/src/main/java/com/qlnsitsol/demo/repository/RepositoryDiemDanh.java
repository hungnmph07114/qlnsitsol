package com.qlnsitsol.demo.repository;


import com.qlnsitsol.demo.entity.DiemDanh;
import com.qlnsitsol.demo.entity.DiemDanhId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryDiemDanh extends JpaRepository<DiemDanh, DiemDanhId> {
    Optional<DiemDanh> countByIdAndDilam (DiemDanhId id,boolean bl);
    @Query(nativeQuery = true, value = "select count(date) as ngaycong from diemdanh where nhanvienid = :nhanvienid and date like %:date% and dilam= true;")
    long countById_NhanVienAndId_DateAndDilam (@Param("nhanvienid") long nhanvienid,@Param("date")String date);
    @Query(nativeQuery = true, value ="select * from diemdanh where date like %:date%")
    List<DiemDanh> getAllById_Date(@Param("date")String date);
    @Query(nativeQuery = true, value ="select * from diemdanh where date like %:date% and nhanvienid = :nhanvienid")
    List<DiemDanh> getAllById_DateAndId_NhanVien_Id(@Param("date")String date,@Param("nhanvienid")String nhanvienid);
//   List<DiemDanh> getAllByDilamAndNhanVienIdAndDateLike(boolean bl,long id, String date);
    boolean existsDiemDanhById_Date(String date);

}
