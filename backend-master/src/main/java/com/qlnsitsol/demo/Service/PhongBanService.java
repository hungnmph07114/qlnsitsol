package com.qlnsitsol.demo.Service;
import com.qlnsitsol.demo.entity.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PhongBanService {
    List<PhongBan> list();
    Optional<PhongBan> getOne(long id);
    Optional<PhongBan> getByName(String s);
    void  save(PhongBan phongBan);
    void delete(long id);
    boolean existsById(long id);
    boolean existsByName(String s);
    Page<PhongBan> page(Pageable pageable);
    Page<PhongBan> pageByActionAndTenPhongBan(String tenPhongBan, Pageable pageable);
}
