/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月8日 上午9:33:32
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.model;

import java.util.List;

/**
  * @ClassName: User
  * @Description: 用户对象
  * @author think
  * @date 2018年8月8日 上午9:33:32
  *
  */
public class User {

    private Long id;
    
    private String account;
    
    private String pwd;
    
    private  List<String> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    
}
