package com.qlnsitsol.demo.serviceIplm;
import com.qlnsitsol.demo.Service.NhanVienService;
import com.qlnsitsol.demo.entity.NhanVien;
import com.qlnsitsol.demo.repository.RepositoryNhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NhanVienIplm implements NhanVienService {
    @Autowired
    RepositoryNhanVien repositoryNhanVien;
    @Override
    public List<NhanVien> list() {
        return repositoryNhanVien.findAll();
    }

    @Override
    public List<NhanVien> timkiem(String name) {
        return repositoryNhanVien.getAllByActionAndTenNhanVienLike(true ,"%"+name+"%");
    }

    @Override
    public Optional<NhanVien> getOne(long id) {
        return repositoryNhanVien.findById(id);
    }

    @Override
    public Optional<NhanVien> getByName(String s) {
        return Optional.empty();
    }

    @Override
    public void save(NhanVien nhanvien) {
    repositoryNhanVien.save(nhanvien);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean existsById(long id) {
        return repositoryNhanVien.existsById(id);
    }

    @Override
    public boolean existsByName(String s) {
        return false;
    }

    @Override
    public boolean existsChucvu(String s, long id) {
        return  repositoryNhanVien.existsByChuVuLikeAndPhongBan_Id(s,id);
    }

    @Override
    public Page<NhanVien> page(Pageable pageable) {
        return null;
    }
}
