package com.qlnsitsol.demo.repository;
import com.qlnsitsol.demo.entity.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface RepositoryPhongBan extends JpaRepository<PhongBan,Long> {
       Optional<PhongBan> findByTenPhongBan(String s);
        Boolean existsByTenPhongBan(String s);

        Page<PhongBan> findAllByTenPhongBanLike(String tenPhongBan, Pageable pageable);

        @Query(nativeQuery = true, value = "select*from phongban join chucvu on phongban.id = chucvu.phongbanid join nhanvien on nhanvien.chucvuid = chucvu.id where chucvu.tenchucvu like 'giam doc'")
        List<PhongBan> listPhongBan();
}
