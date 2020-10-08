package com.qlnsitsol.demo.Service;
import com.qlnsitsol.demo.entity.Luong;
import com.qlnsitsol.demo.entity.LuongId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LuongService {
    List<Luong> list();
    List<Luong> getAllByNhanVienId(long id);
    Optional<Luong> getOne(LuongId id);
    Optional<Luong> getByName(String s);
    void  save(Luong luong);
    void delete(int id);
    boolean existsById(int id);
    boolean existsByName(String s);
    Page<Luong> page(Pageable pageable);
}
