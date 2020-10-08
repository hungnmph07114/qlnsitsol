package com.qlnsitsol.demo.Controller;

import com.qlnsitsol.demo.DTO.*;
import com.qlnsitsol.demo.Service.DiemDanhService;
import com.qlnsitsol.demo.Service.NhanVienService;
import com.qlnsitsol.demo.Service.RoleService;
import com.qlnsitsol.demo.Service.UserService;
import com.qlnsitsol.demo.entity.*;
import com.qlnsitsol.demo.enums.RoleName;
import com.qlnsitsol.demo.messager.Messager;
import com.qlnsitsol.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nhanvien")
@CrossOrigin(origins = "*")
public class ControllerNhanVien {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    RepositoryNhanVien repo;
    @Autowired
    RepositoryDiemDanh repositoryDiemDanh;
    @Autowired
    RepositoryLuong repositoryLuong;
    @Autowired
    RepositoryKhenThuong repositoryKhenThuong;
    @Autowired
    RepositoryNhanVien repositoryNhanVien;
    @Autowired
    RepositoryPhongBan repositoryPhongBan;
    @Autowired
    DiemDanhService diemDanhService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    CreNhanVienDTO creNhanVienDTO;
    @GetMapping("/pages")
    public ResponseEntity<Page<NhanVien>> pageResponseEntity(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "tenNhanVien") String order,
            @RequestParam(defaultValue = "true") boolean asc,
            @RequestParam(defaultValue = "true") boolean action,
            @RequestParam long phongbanid,
            @RequestParam (defaultValue = "")String tenNhanVien
    ){
        Page<NhanVien> pages = repositoryNhanVien.findAllByPhongBanIdAndActionAndTenNhanVienLike(phongbanid,action,"%"+tenNhanVien+"%",PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            pages = repositoryNhanVien.findAllByPhongBanIdAndActionAndTenNhanVienLike(phongbanid,action,tenNhanVien,PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<NhanVien>>(pages, HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> user(
            @RequestParam(defaultValue = "true") boolean action

    ){

           List<User> users = userService.USERS(action);
           List<UserDTO> userDTOS = new ArrayList<>();

            if (users.isEmpty()){
                return new ResponseEntity( HttpStatus.NOT_FOUND);
            }
        for ( User user: users) {

            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setNhanVien(user.getNhanVien());
            userDTO.setHoatDong(user.isHoatDong());
            userDTOS.add(userDTO);
        }
        return new ResponseEntity<List<UserDTO>>(userDTOS, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public  ResponseEntity<?> getoneUser(@PathVariable("id") int id){
        Optional<User> user = userService.getone(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(new Message("RỖNG"),HttpStatus.NOT_FOUND);
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setNhanVien(user.get().getNhanVien());
        userDTO.setHoatDong(user.get().isHoatDong());
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id")int id, @RequestBody UserDTO dto){
        Optional<User> user = userService.getone(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(new Message("RỖNG"),HttpStatus.NOT_FOUND);
        }
         user.get().setHoatDong(dto.isHoatDong());
         userService.save(user.get());
        return new ResponseEntity(new Message("Cap nhat thanh cong"), HttpStatus.OK);
    }
    @PutMapping("/user/updatepass")
    public ResponseEntity<?> updateUserpass( @RequestBody UserDTO dto){
       User user = userService.getByUserName(dto.getUserName()).get();
        System.out.println(user.getPassword());
        String pass = passwordEncoder.encode(dto.getPassword());
        System.out.println(pass);
        user.setPassword(pass);
        userService.save(user);
        return new ResponseEntity(new Message("Cap nhat thanh cong"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getoneNhanVien(@PathVariable("id") long id){
        Optional<NhanVien> nhanVien = nhanVienService.getOne(id);
        if (nhanVien.isEmpty()){
            return  new ResponseEntity(new Message("Nhân viên Không tồn tại"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nhanVien,HttpStatus.OK);
    }
    @GetMapping("/timkiemuser")
    public  ResponseEntity<?> tiemkiemuser( @RequestParam(defaultValue = "") String ten){
        List<UserDTO> userDTOS = new ArrayList<>();
        if (ten == null){
            List<User> users = userService.getlist();

            if (users.isEmpty()){
                return new ResponseEntity( HttpStatus.NOT_FOUND);
            }
            for ( User user: users) {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId());
                userDTO.setUserName(user.getUserName());
                userDTO.setNhanVien(user.getNhanVien());
                userDTO.setHoatDong(user.isHoatDong());
                userDTOS.add(userDTO);
            }
            return new ResponseEntity<List<UserDTO>>(userDTOS, HttpStatus.OK);
        }
        List<User> users = userService.timkiem(ten);
        if (users.isEmpty()){
            return  new ResponseEntity(new Message("tài khoản Không tồn tại"),HttpStatus.NOT_FOUND);
        }
        for ( User user: users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setNhanVien(user.getNhanVien());
            userDTO.setHoatDong(user.isHoatDong());
            userDTOS.add(userDTO);
        }
        return new ResponseEntity<>(userDTOS,HttpStatus.OK);
    }
    @GetMapping("/timkiem")
    public  ResponseEntity<?> tiemkiem( @RequestParam(defaultValue = "") String ten){
      if (ten == null){
          List<NhanVien> nv = repo.getAllByAction(true);
          NhanVienDTO dto = new NhanVienDTO();
//        nv.stream().map(dto::toDTO).collect(Collectors.toList());
          if (nv.isEmpty()){
              return new  ResponseEntity(new Messager("Khong ton tai"), HttpStatus.NOT_FOUND);
          }
          return new  ResponseEntity(nv, HttpStatus.OK);
      }
        List<NhanVien> nhanVien = nhanVienService.timkiem(ten);
        if (nhanVien.isEmpty()){
            return  new ResponseEntity(new Message("Nhân viên Không tồn tại"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nhanVien,HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<NhanVien>> listResponseEntity(){
        List<NhanVien> nv = repo.getAllByAction(true);
        NhanVienDTO dto = new NhanVienDTO();
//        nv.stream().map(dto::toDTO).collect(Collectors.toList());
        if (nv.isEmpty()){
            return new  ResponseEntity(new Messager("Khong ton tai"), HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity(nv, HttpStatus.OK);
    }
    @PostMapping("/newNhanVien")
    public ResponseEntity<?> create(@RequestBody CreNhanVienDTO dto){
        PhongBan pb = repositoryPhongBan.findById(dto.getPhongbanid()).get();
        NhanVien nv = new NhanVien();
        nv.setNgayBatDau(dto.getNgayBatDau());
        nv.setAction(dto.getAction());
        nv.setTenNhanVien(dto.getTenNhanVien());
        nv.setNgaySinh(dto.getNgaySinh());
        nv.setGioiTinh(dto.getGioiTinh());
        nv.setDiaChi(dto.getDiaChi());
        if (repositoryNhanVien.existsBySoCmnnd(dto.getSoCmnnd())){
            return new ResponseEntity<>(new Message("Số CMND đã tồn tại"),HttpStatus.NOT_FOUND);
        }
        if ( dto.getSoCmnnd().length() < 10){
            return new ResponseEntity<>(new Message("Số CMND phải nhiều hơn 10 kí tự"),HttpStatus.NOT_FOUND);
        }
        nv.setSoCmnnd(dto.getSoCmnnd());
        nv.setDienThoai(dto.getDienThoai());
        nv.setChuVu(dto.getChuVu());
        nv.setEmail(dto.getEmail());
        nv.setImg(dto.getImg());

        if (dto.getImg() == null){
            nv.setImg("https://lh3.googleusercontent.com/proxy/205uKloUxCwYUH7mQmJ1cBEpo-UVRf6s_4fsSi7i2Z12Z5yos4uEVU1-AAN5JKxktZ4IYZLQdSlanYzT3ci8L-MMemay3FlzQtrawLb7UA");
        }
        nv.setPhongBan(pb);
        nhanVienService.save(nv);
        return new ResponseEntity(new Message("Them nhan vien moi thanh cong"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody CreNhanVienDTO dto){

        if(!nhanVienService.existsById(id)) {
            return new ResponseEntity(new Message("no exists"), HttpStatus.NOT_FOUND);
        }
        PhongBan pb = repositoryPhongBan.findById(dto.getPhongbanid()).get();
        NhanVien nv = nhanVienService.getOne(id).get();
        nv.setAction(dto.getAction());
        nv.setTenNhanVien(dto.getTenNhanVien());
        nv.setNgaySinh(dto.getNgaySinh());
        nv.setGioiTinh(dto.getGioiTinh());
        nv.setDiaChi(dto.getDiaChi());
        if (nv.getSoCmnnd().equals(dto.getSoCmnnd())){
            nv.setSoCmnnd(dto.getSoCmnnd());
        } else if (repositoryNhanVien.existsBySoCmnnd(dto.getSoCmnnd())){

                return new ResponseEntity<>(new Message("Số CMND đã tồn tại"),HttpStatus.NOT_FOUND);
            }
        if ( dto.getSoCmnnd().length() < 10){
            return new ResponseEntity<>(new Message("Số CMND phải nhiều hơn 10 kí tự"),HttpStatus.NOT_FOUND);
        }
        nv.setDienThoai(dto.getDienThoai());
        nv.setChuVu(dto.getChuVu());
        nv.setEmail(dto.getEmail());
        nv.setImg(dto.getImg());
        nv.setPhongBan(pb);
        nv.setNgayBatDau(dto.getNgayBatDau());
        nv.setNgayKetThuc(dto.getNgayKetThuc());
        nhanVienService.save(nv);
        return new ResponseEntity(new Message("Cap nhat thanh cong"), HttpStatus.OK);
    }
    @PutMapping("/update/img/{id}")
    public ResponseEntity<?> updateimg(@PathVariable("id")Long id, @RequestBody CreNhanVienDTO dto){
        if(!nhanVienService.existsById(id)) {
            return new ResponseEntity(new Message("no exists"), HttpStatus.NOT_FOUND);
        }
        PhongBan pb = repositoryPhongBan.findById(dto.getPhongbanid()).get();
        NhanVien nv = nhanVienService.getOne(id).get();
        nv.setImg(dto.getImg());

        nhanVienService.save(nv);
        return new ResponseEntity(new Message("Cap nhat thanh cong"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!nhanVienService.existsById(id)) {
            return new ResponseEntity(new Message("no exists"), HttpStatus.NOT_FOUND);
        }
        NhanVien nv = nhanVienService.getOne(id).get();
        nv.setAction(false);
        nhanVienService.save(nv);
        return new ResponseEntity(new Message("Xoa thanh cong"), HttpStatus.OK);
    }
    @PostMapping("/diemdanh")
    public ResponseEntity<?> create1(@RequestBody DiemDanhDTO dto){

//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        String strDate = dateFormat.format(date);
        DiemDanh dd = new DiemDanh();
        NhanVien nv = nhanVienService.getOne(dto.getNhanvienid()).get();
        DiemDanhId diemDanhId = new DiemDanhId();
        diemDanhId.setDate(dto.getDate());
        diemDanhId.setNhanVien(nhanVienService.getOne(dto.getNhanvienid()).get());
        dd.setId(diemDanhId);
        dd.setDilam(dto.isDilam());
        diemDanhService.save(dd);
        return new ResponseEntity(new Message("Điểm danh thành công"), HttpStatus.OK);
    }

    @GetMapping("/diemdanhAll/{date}")
    public ResponseEntity<?> diemDanh(@PathVariable("date") String date){
        if(diemDanhService.existsDiemDanhById_Date(date)){
            return new ResponseEntity(repositoryDiemDanh.getAllById_Date(date), HttpStatus.OK);
        }else if(!diemDanhService.existsDiemDanhById_Date(date)){
        List<NhanVien> nv = repo.getAllByAction(true);
        DiemDanhId diemDanhId = new DiemDanhId();
        DiemDanh dd = new DiemDanh();
        for (int i = 0; i <nv.size() ; i++) {
            diemDanhId.setDate(date);
            diemDanhId.setNhanVien(nhanVienService.getOne(nv.get(i).getId()).get());
            dd.setId(diemDanhId);
            dd.setDilam(false);
            diemDanhService.save(dd);
        }
        }
        return new ResponseEntity(repositoryDiemDanh.getAllById_Date(date), HttpStatus.OK);
    }

    @GetMapping("/listDiemDanhById")
    public  ResponseEntity<?> getDiemDanhById(@RequestParam(defaultValue = "") String nhanvienid,@RequestParam(defaultValue = "") String date){

       return new ResponseEntity(diemDanhService.getAllById_DateAndId_NhanVien_Id(date,nhanvienid),HttpStatus.OK);
    }
}
