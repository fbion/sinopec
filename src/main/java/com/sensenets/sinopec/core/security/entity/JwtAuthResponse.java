package com.sensenets.sinopec.core.security.entity;

import java.io.Serializable;

/**
 * @ClassName: JwtAuthenticationResponse
 * @Description: JwtAuthenticationResponse
 * @author xupengtao
 * @date 2016年6月8日 下午2:08:16
 *
 */
public class JwtAuthResponse implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1250166508152483573L;

    /**
     * token
     */
    private String token;

    /**
     * 扩展信息
     */
    private String ext;

    public JwtAuthResponse() {
    }

    public JwtAuthResponse(String token) {
        this.token = token;
    }

    public JwtAuthResponse(String token, String ext) {
        this.token = token;
        this.ext = ext;
    }

    public String getExt() {
        return ext;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

}
