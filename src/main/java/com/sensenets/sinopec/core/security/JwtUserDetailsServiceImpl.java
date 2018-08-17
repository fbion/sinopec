package com.sensenets.sinopec.core.security;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sensenets.sinopec.buiness.model.VjUserLoginView;
import com.sensenets.sinopec.buiness.service.IVjUserLoginViewService;
import com.sensenets.sinopec.core.security.entity.JwtUserFactory;


/**
  * @ClassName: JwtUserDetailsServiceImpl
  * @Description: 提供一种从用户名可以查到用户并返回
  * @author think
  * @date 2018年8月8日 上午9:45:42
  *
  */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IVjUserLoginViewService  userLoginViewService;
    
    /**
     * 提供一种从用户名可以查到用户并返回的方法
     * @param account
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        List<VjUserLoginView> views = userLoginViewService.findForLogin(account);
        if(CollectionUtils.isNotEmpty(views)){
            return JwtUserFactory.createFromList(views);
        } else {
            throw new UsernameNotFoundException("登录的用户不存在！");
        }
    }
}

