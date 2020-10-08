package com.qlnsitsol.demo.serviceIplm;


import com.qlnsitsol.demo.Service.DiemDanhService;
import com.qlnsitsol.demo.entity.DiemDanh;
import com.qlnsitsol.demo.repository.RepositoryDiemDanh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiemDanhImpl implements DiemDanhService {
    @Autowired
    RepositoryDiemDanh repositoryDiemDanh;
    @Override
    public void save(DiemDanh dd) {
        repositoryDiemDanh.save(dd);
    }

    @Override
    public boolean existsDiemDanhById_Date(String date) {
        return repositoryDiemDanh.existsDiemDanhById_Date(date);
    }

    @Override
    public List<DiemDanh> getAllById_DateAndId_NhanVien_Id(String date, String nhanvienid) {
        return repositoryDiemDanh.getAllById_DateAndId_NhanVien_Id(date,nhanvienid);
    }
}
