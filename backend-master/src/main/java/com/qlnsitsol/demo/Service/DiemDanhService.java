package com.qlnsitsol.demo.Service;


import com.qlnsitsol.demo.entity.DiemDanh;

import java.util.List;

public interface DiemDanhService {
    void save(DiemDanh dd);
    boolean existsDiemDanhById_Date(String date);
    List<DiemDanh> getAllById_DateAndId_NhanVien_Id(String date,String nhanvienid);
}
