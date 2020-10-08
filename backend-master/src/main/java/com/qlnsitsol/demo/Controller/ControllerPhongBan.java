package com.qlnsitsol.demo.Controller;


import com.qlnsitsol.demo.DTO.PhongBanDTO;
import com.qlnsitsol.demo.Service.PhongBanService;
import com.qlnsitsol.demo.entity.NhanVien;
import com.qlnsitsol.demo.entity.PhongBan;
import com.qlnsitsol.demo.messager.Messager;
import com.qlnsitsol.demo.repository.RepositoryNhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/phongban")
@CrossOrigin
public class ControllerPhongBan {
    @Autowired
    PhongBanService phongBanService;
    @Autowired
    RepositoryNhanVien repo;

    @GetMapping("/pages")
    public ResponseEntity<Page<PhongBan>> pageResponseEntity(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "tenPhongBan") String order,
            @RequestParam(defaultValue = "true") boolean asc,
            @RequestParam String tenPhongBan
    ){
        Page<PhongBan> pages = phongBanService.pageByActionAndTenPhongBan("%"+tenPhongBan+"%", PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            pages = phongBanService.pageByActionAndTenPhongBan("%"+tenPhongBan+"%",PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<PhongBan>>(pages, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') ")
    @GetMapping()
    public ResponseEntity<List<PhongBan>> list(){
       List<PhongBan> phongBans = phongBanService.list();
       if (phongBans.isEmpty()){
           return  new ResponseEntity(new Messager("Chưa có Phòng Ban nào"),HttpStatus.NOT_FOUND);
       }
        return new  ResponseEntity( phongBans, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @GetMapping("/{id}")
    public ResponseEntity<PhongBan> getone(@PathVariable("id") long id){
        Optional<PhongBan> phongBan = phongBanService.getOne(id);
        if (phongBan.isEmpty()){
            return new ResponseEntity(new Messager("Không tồn tại"),HttpStatus.NOT_FOUND);
        }
        System.out.println(  phongBan.get().getTenPhongBan());
      return  new   ResponseEntity<PhongBan>(phongBan.get(),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @GetMapping("/list")
    public ResponseEntity<List<PhongBanDTO>> listResponseEntity(){
        List<NhanVien> phongBans = repo.getAllByChuVuLikeAndActionAndPhongBan_Action("giam đốc",true,true);
        PhongBanDTO dto = new PhongBanDTO();
        phongBans.stream().map(dto::toDTO).collect(Collectors.toList());
        if (phongBans.isEmpty()){
            return new  ResponseEntity(new Messager("Khong ton tai"), HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity(phongBans.stream().map(dto::toDTO).collect(Collectors.toList()), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')or hasRole('MANAGER')")
    @PostMapping("/add")
        public ResponseEntity<?>add(@RequestBody PhongBan phongBan ,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  new ResponseEntity( new Messager("không được để trống") ,  HttpStatus.BAD_REQUEST);
        }else if(phongBanService.existsByName(phongBan.getTenPhongBan())){
            return  new ResponseEntity(new Messager("Tên phòng ban đã tồn tại"),HttpStatus.BAD_REQUEST);
        }else
            if (phongBan.getImg() == null){
                phongBan.setImg("https://i.imgur.com/JrygMEz.jpg");
            }
            phongBan.setAction(true);
            phongBanService.save(phongBan);
        return new ResponseEntity<>(new Messager("Thêm phòng ban"), HttpStatus.OK);

    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<PhongBan> update(@PathVariable("id") long id, @RequestBody PhongBan phongBan){
        if(!phongBanService.existsById(id))
            return new ResponseEntity(new Messager("Khong ton tai"), HttpStatus.NOT_FOUND);
        if(phongBanService.existsByName(phongBan.getTenPhongBan()) && phongBanService.getByName(phongBan.getTenPhongBan()).get().getId() != id)
            return new ResponseEntity(new Messager("tên đó đã tồn tại"), HttpStatus.BAD_REQUEST);
        if (phongBan.getTenPhongBan() == null)
            return new ResponseEntity(new Messager("tên khong de trong"), HttpStatus.BAD_REQUEST);
               Optional<PhongBan> phongBan1 = phongBanService.getOne(id);
               phongBan1.get().setTenPhongBan(phongBan.getTenPhongBan());
               phongBan1.get().setDienThoai(phongBan.getDienThoai());
               phongBan1.get().setGhiChu(phongBan.getGhiChu());
               phongBan1.get().setImg(phongBan.getImg());
               phongBan1.get().setAction(phongBan.getAction());
               phongBanService.save(phongBan1.get());
               return new ResponseEntity<>(phongBan1.get(),HttpStatus.OK);
    }
}
