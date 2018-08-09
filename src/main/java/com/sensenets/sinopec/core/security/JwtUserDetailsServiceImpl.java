package com.sensenets.sinopec.core.security;

import com.sensenets.sinopec.buiness.model.User;
import com.sensenets.sinopec.common.utils.MD5Helper;
import com.sensenets.sinopec.core.security.entity.AuthorityName;
import com.sensenets.sinopec.core.security.entity.JwtUserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
  * @ClassName: JwtUserDetailsServiceImpl
  * @Description: 提供一种从用户名可以查到用户并返回
  * @author think
  * @date 2018年8月8日 上午9:45:42
  *
  */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    /**
     * 提供一种从用户名可以查到用户并返回的方法
     * @param account
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        /**TODO:此处需要写明从用户表里面跟根据用户account查询用户的方法**/
        User user =new User();
        user.setAccount("admin");
        user.setPwd(MD5Helper.toMD5("123"));
        user.setId(1L);
        List<String> roles=new ArrayList<>();
        roles.add(AuthorityName.ROLE_PLATFORM.getIndex());
        user.setRoles(roles);
        return JwtUserFactory.create(user);
    }
}