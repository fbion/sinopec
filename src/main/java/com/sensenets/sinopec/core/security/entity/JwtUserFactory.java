package com.sensenets.sinopec.core.security.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sensenets.sinopec.buiness.model.one.VjUserLoginView;

/**
  * @ClassName: JwtUserFactory
  * @Description: 根据VjUserLoginView创建JwtUser
  * @author think
  * @date 2018年8月8日 上午9:32:54
  *
  */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    
    public static JwtUser createFromList(List<VjUserLoginView> users) {
        List<String> funcAuthorities = new ArrayList<String>();
        List<String> sensorAuthorities = new ArrayList<String>();
        users.forEach(view ->{
            funcAuthorities.add(view.getFuncRoleId());
            sensorAuthorities.add(view.getSensorRoleId());
        });
        
        return new JwtUser(
                users.get(0).getUserId(),
                users.get(0).getUserName(),
                users.get(0).getPwd(),
                users.get(0).getEnable()==1?true:false,
                users.get(0).getStatus()==4?false:true,
                mapToGrantedAuthorities(funcAuthorities),
                mapToGrantedAuthorities(sensorAuthorities)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authoritys) {
        return authoritys.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}