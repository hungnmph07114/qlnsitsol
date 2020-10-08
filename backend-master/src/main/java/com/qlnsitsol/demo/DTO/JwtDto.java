package com.qlnsitsol.demo.DTO;

import com.qlnsitsol.demo.entity.NhanVien;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private long nhanVienId;

    String value;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String userName,long nhanVienId, Collection<? extends GrantedAuthority> authorities) {
        this.nhanVienId = nhanVienId;
        this.token = token;
        this.userName = userName;
        this.authorities = authorities;
    }

    public long getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(long nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
