package com.sensenets.sinopec.core.security.entity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sensenets.sinopec.buiness.model.User;

/**
  * @ClassName: JwtUserFactory
  * @Description: 根据User创建JwtUser
  * @author think
  * @date 2018年8月8日 上午9:32:54
  *
  */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getAccount(),//account是唯一的
                user.getPwd(),
                mapToGrantedAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}