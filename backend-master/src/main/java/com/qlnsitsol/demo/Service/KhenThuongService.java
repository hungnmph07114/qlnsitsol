package com.qlnsitsol.demo.Service;
import com.qlnsitsol.demo.entity.KhenThuongKl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface KhenThuongService {
    List<KhenThuongKl> list();
    Optional<KhenThuongKl> getOne(long id);
    Optional<KhenThuongKl> getByName(String s);
    void  save(KhenThuongKl khenThuongKl);
    void delete(int id);
    boolean existsById(int id);
    boolean existsByName(String s);
    Page<KhenThuongKl> page(Pageable pageable);
}
