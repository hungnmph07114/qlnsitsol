package com.qlnsitsol.demo.repository;

import com.qlnsitsol.demo.entity.KhenThuongKl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryKhenThuong extends JpaRepository<KhenThuongKl,Long> {

}
