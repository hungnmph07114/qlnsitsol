package com.qlnsitsol.demo.Controller;
import com.qlnsitsol.demo.DTO.*;
import com.qlnsitsol.demo.Service.KhenThuongService;
import com.qlnsitsol.demo.Service.LuongService;
import com.qlnsitsol.demo.Service.NhanVienService;
import com.qlnsitsol.demo.entity.*;
import com.qlnsitsol.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/luong")
@CrossOrigin(origins = "*")
public class ControllerLuong {
    @Autowired
    RepositoryLuong repositoryLuong;
    @Autowired
    KhenThuongService khenThuongService;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    LuongService luongService;
    @Autowired
    RepositoryDiemDanh repositoryDiemDanh;
    @Autowired
    RepositoryKyluat repositoryKyluat;
    @Autowired
    RepositoryHeSoLuong repositoryHeSoLuong;
    @Autowired
    RepositoryPhuCap repositoryPhuCap;
    @Autowired
    RepositoryTamUng repositoryTamUng;
    @Autowired
    RepositoryNhanVien repositoryNhanVien;
    @GetMapping("/bangluong")
    public ResponseEntity<?> luong(@RequestParam(defaultValue = "") String date){
        List<DiemDanh> dd = repositoryDiemDanh.getAllById_Date(date);

        List<Luong> bangluong = repositoryLuong.getAllById_NhanVien_ActionAndId_Date(true,date);
        if(dd.size() != 0){
            addBangLuong(date);
            return  new ResponseEntity(bangluong,HttpStatus.OK);
        }
        if (bangluong.isEmpty()){
            return  new ResponseEntity(new Message("Tháng này chưa có bảng lương"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bangluong,HttpStatus.OK);
    }
    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response, @RequestParam(defaultValue = "")String date) throws IOException {

        response.setContentType("application/octet-stream");
        String date1 = "2020-09";
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=BangLuong.xlsx";
        response.setHeader(headerKey, headerValue);
        List<Luong> bangluong = repositoryLuong.getAllById_NhanVien_ActionAndId_Date(true,date);
        ExcelFileExporter excelExporter = new ExcelFileExporter(bangluong);
        excelExporter.export(response);
    }

    @GetMapping("LuongById")
    public ResponseEntity<?> getLuongByNhanVienId(@RequestParam(defaultValue = "") long id){
        List<Luong> list = luongService.getAllByNhanVienId(id);
        if(list.isEmpty()){
            return new ResponseEntity(new Message("Nhân viên có lương"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    public ResponseEntity<?> addBangLuong(String date){
        List<NhanVien> nhanVienList = repositoryNhanVien.getAllByAction(true);
        long idpc = 1;long idta = 1;long idhsl = 1;long idkl = 1; long idkt=1;
        PhuCap pc =repositoryPhuCap.getOne(idpc);

        TamUng ta = repositoryTamUng.getOne(idta);

        KhenThuongKl kt = khenThuongService.getOne(idkt).get();

        HeSoLuong hsl = repositoryHeSoLuong.getOne(idhsl);

        KyLuat kl = repositoryKyluat.getOne(idkl);

        for (int i = 0; i < nhanVienList.size(); i++) {
            NhanVien nv = nhanVienService.getOne(nhanVienList.get(i).getId()).get();

            LuongId luongId = new LuongId();
            luongId.setNhanVien(nv);
            luongId.setDate(date);
            if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(nhanVienList.get(i).getId(),date)){
                Luong newLuong = new Luong();
                newLuong.setId(luongId);
                newLuong.setPhuCap(pc);
                newLuong.setTamUng(ta);
                newLuong.setKyLuat(kl);
                newLuong.setHeSoLuong(hsl);
                newLuong.setKhenThuongKl(kt);
                newLuong.setNgayCong("0");
                luongService.save(newLuong);
            }
        }

        return new ResponseEntity<>(new Message("Đã tạo bảng lương mới"),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @GetMapping("/chamcong")
    public ResponseEntity<?> addNgayCong(@RequestParam(defaultValue = "") String date){
        List<NhanVien> nhanVienList = repositoryNhanVien.getAllByAction(true);
        List<DiemDanh> dd = repositoryDiemDanh.getAllById_Date(date);
        if(dd.size() == 0){
            return  new ResponseEntity(new Message("Tháng này chưa điểm danh"),HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < nhanVienList.size(); i++) {
            NhanVien nv = nhanVienService.getOne(nhanVienList.get(i).getId()).get();
            DiemDanhId dd1 = new DiemDanhId();
            dd1.setDate(date);
            dd1.setNhanVien(nv);

            LuongId luongId = new LuongId();
            luongId.setNhanVien(nv);
            luongId.setDate(date);
            if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(nhanVienList.get(i).getId(),date)){
                Luong newLuong = new Luong();
                newLuong.setId(luongId);
                luongService.save(newLuong);
            }
            Luong luong = repositoryLuong.getOne(luongId);
//        DiemDanh dd = luongService.getOne().get();

            String ngaycong = String.valueOf(repositoryDiemDanh.countById_NhanVienAndId_DateAndDilam(nhanVienList.get(i).getId(),date));
            luong.setId(luongId);
            luong.setNgayCong(ngaycong);
            luongService.save(luong);
        }

        return new ResponseEntity<>(new Message("lưu ngày công"),HttpStatus.OK);
    }


    @PostMapping("/khenthuong")
    public ResponseEntity<?> addkhenthuong(@RequestBody KhenThuongDTO dto){
        LuongId id1 = new LuongId();
        NhanVien nv = nhanVienService.getOne(dto.getNhanvienid()).get();

        id1.setDate(dto.getDate());
        id1.setNhanVien(nv);

        LuongId luongId = new LuongId();
        luongId.setNhanVien(nv);
        luongId.setDate(dto.getDate());
        if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(dto.getNhanvienid(),dto.getDate())){
            Luong newLuong = new Luong();
            newLuong.setId(luongId);
            luongService.save(newLuong);
        }
        Luong luong = repositoryLuong.getOne(luongId);
        KhenThuongKl khenThuongKl = new KhenThuongKl();
        khenThuongKl.setHinhThuc(dto.getHinhthuc());
        khenThuongKl.setNoiDung(dto.getNoidung());
        khenThuongKl.setSoTien(dto.getSotien());
        khenThuongService.save(khenThuongKl);
        luong.setKhenThuongKl(khenThuongKl);
        luongService.save(luong);

//
//
        return new ResponseEntity<>(khenThuongKl,HttpStatus.OK);
    }

    @PostMapping("/kyluat")
    public ResponseEntity<?> addKyLuat(@RequestBody KyluatDTO dto){
        LuongId id1 = new LuongId();
        NhanVien nv = nhanVienService.getOne(dto.getNhanvienid()).get();
        KyLuat kyluat = new KyLuat();

        id1.setDate(dto.getNgayPhat());
        id1.setNhanVien(nv);
        LuongId luongId = new LuongId();
        luongId.setNhanVien(nv);
        luongId.setDate(dto.getNgayPhat());
        if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(dto.getNhanvienid(),dto.getDate())){
            Luong newLuong = new Luong();
            newLuong.setId(luongId);
            luongService.save(newLuong);
        }
        Luong luong = repositoryLuong.getOne(luongId);

        kyluat.setHinhthuckyluat(dto.getHinhthuckyluat());
        kyluat.setLyDo(dto.getLyDo());
        kyluat.setNgayPhat(dto.getNgayPhat());
        kyluat.setTienPhat(dto.getTienPhat());
        repositoryKyluat.save(kyluat);
        luong.setKyLuat(kyluat);
        luongService.save(luong);
        return new ResponseEntity<>(kyluat,HttpStatus.OK);
    }
    @PostMapping("/hesoluong")
    public ResponseEntity<?> addKyLuat(@RequestBody HeSoLuongDTO dto){
        LuongId id1 = new LuongId();
        System.out.println(dto.getNgayDieuChinhLuong());
        System.out.println(dto.getHeSoLuong());
        NhanVien nv = nhanVienService.getOne(dto.getNhanvienid()).get();

        id1.setDate(dto.getDate());
        id1.setNhanVien(nv);

        LuongId luongId = new LuongId();
        luongId.setNhanVien(nv);
        luongId.setDate(dto.getDate());
        if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(dto.getNhanvienid(),dto.getDate())){
            Luong newLuong = new Luong();
            newLuong.setId(luongId);
            luongService.save(newLuong);
        }
        Luong luong = repositoryLuong.getOne(luongId);
        HeSoLuong hsl = new HeSoLuong();
        hsl.setHeSoLuong(dto.getHeSoLuong());
        hsl.setNgayDieuChinhLuong(dto.getDate());

        repositoryHeSoLuong.save(hsl);
        luong.setHeSoLuong(hsl);
        luongService.save(luong);
        return new ResponseEntity<>(hsl,HttpStatus.OK);
    }
    @PostMapping("/phucap")
    public ResponseEntity<?> addKyLuat(@RequestBody PhuCapDTO dto){
        System.out.println(dto.getTienPhuCap());
        LuongId id1 = new LuongId();
        NhanVien nv = nhanVienService.getOne(dto.getNhanvienid()).get();
        id1.setDate(dto.getDate());
        id1.setNhanVien(nv);

        LuongId luongId = new LuongId();
        luongId.setNhanVien(nv);
        luongId.setDate(dto.getDate());
        if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(dto.getNhanvienid(),dto.getDate())){
            Luong newLuong = new Luong();
            newLuong.setId(luongId);
            luongService.save(newLuong);
        }
        Luong luong = repositoryLuong.getOne(luongId);
        PhuCap pc = new PhuCap();
        pc.setNgayPhuCap(dto.getDate());
        pc.setTienPhuCap(dto.getTienPhuCap());


        repositoryPhuCap.save(pc);
        luong.setPhuCap(pc);
        luongService.save(luong);
        return new ResponseEntity<>(pc,HttpStatus.OK);
    }
    @PostMapping("/tamung")
    public ResponseEntity<?> addKyLuat(@RequestBody TamUngDTO dto){
        LuongId id1 = new LuongId();
        NhanVien nv = nhanVienService.getOne(dto.getNhanvienid()).get();
        TamUng tamUng = new TamUng();
        id1.setDate(dto.getDate());
        id1.setNhanVien(nv);

        LuongId luongId = new LuongId();
        luongId.setNhanVien(nv);
        luongId.setDate(dto.getDate());
        if(!repositoryLuong.existsById_NhanVien_IdAndId_Date(dto.getNhanvienid(),dto.getDate())){
            Luong newLuong = new Luong();
            newLuong.setId(luongId);
            luongService.save(newLuong);
        }
        Luong luong = repositoryLuong.getOne(luongId);

        tamUng.setLyDo(dto.getLyDo());
        tamUng.setNgayTamUng(dto.getNgayTamUng());
        tamUng.setTienTamung(dto.getTienTamung());

        repositoryTamUng.save(tamUng);
        luong.setTamUng(tamUng);
        luongService.save(luong);
        return new ResponseEntity<>(tamUng,HttpStatus.OK);
    }


}
