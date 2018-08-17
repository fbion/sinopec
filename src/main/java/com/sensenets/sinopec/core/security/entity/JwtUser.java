package com.sensenets.sinopec.core.security.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

import lombok.Data;

/**
  * @ClassName: JwtUser
  * @Description: 为了安全服务的User
  * @author think
  * @date 2018年8月8日 上午9:31:27
  *
  */
@Data
public class JwtUser  implements UserDetails {

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = -1511562200158179564L;
    
    private final String userId;
    private final String username; 
    private final String password;
    // 是否启用
    private final boolean enable;
    // 是否删除
    private final boolean status;
    
    // 功能角色
    private final Collection<? extends GrantedAuthority> funAuthorities;
    // 设备角色
    private final Collection<? extends GrantedAuthority> sensorAuthorities;
    
    

    public JwtUser(String userId,String username, String password,boolean enable,boolean status,Collection<? extends GrantedAuthority> funAuthorities,Collection<? extends GrantedAuthority> sensorAuthorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.status = status;
        this.funAuthorities = funAuthorities;
        this.sensorAuthorities = sensorAuthorities;
    }

    /**
     * 返回分配给用户的功能角色列表
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.funAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 账户是否未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否启用
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }



}