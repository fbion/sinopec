package com.sensenets.sinopec.buiness.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.ResponseInfo;
import com.sensenets.sinopec.common.utils.SpringMVCHelper;
import com.sensenets.sinopec.config.JwtConfig;
import com.sensenets.sinopec.core.security.entity.JwtAuthRequest;
import com.sensenets.sinopec.core.security.entity.JwtAuthResponse;
import com.sensenets.sinopec.core.security.entity.JwtUser;
import com.sensenets.sinopec.core.security.entity.ResponseMessage;
import com.sensenets.sinopec.core.security.util.JwtUtil;
import com.sensenets.sinopec.core.security.util.SecurityHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
  * @ClassName: AuthController
  * @Description: 用户验证control
  * @author xzc
  * @date 2018年1月8日 下午2:54:11
  *
  */
@RestController
@RequestMapping(value = "/service/auth", method = RequestMethod.POST)
@Api(value="AuthController",tags="认证操作接口", description="AuthController")
public class AuthController extends BaseController{
  
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
 
    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @ApiOperation(value = "用户验证，创建token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseInfo createToken(@RequestBody JwtAuthRequest authRequest) throws Exception {
        try {
            // 将认证信息保存
            final Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 认证通过后，重新加载密码，生成token
            final JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(authRequest.getUsername());
            // 账户大小写敏感校验
            if (!JwtUtil.isSameUid(authRequest.getUsername(), jwtUser.getUsername())) {
                return this.warpObject(new ResponseInfo(ResponseMessage.RESULT_FAIL_NAME.getIndex(), ResponseMessage.RESULT_FAIL_NAME.getName()),null);
            }
            // 生成token
            String token = jwtUtil.generateToken(jwtUser);
            return this.warpObject(new ResponseInfo(ResponseMessage.RESULT_SUSSECC.getIndex(), ResponseMessage.RESULT_SUSSECC.getName()),token);
        } catch (BadCredentialsException e) {
            // 用户名或密码错误
            return this.warpObject(new ResponseInfo(ResponseMessage.RESULT_FAIL_NAME.getIndex(), ResponseMessage.RESULT_FAIL_NAME.getName()),null);
        } catch (DisabledException e) {
            // 正常禁用
            return this.warpObject(new ResponseInfo(ResponseMessage.ACCOUNT_DISABLE.getIndex(), ResponseMessage.ACCOUNT_DISABLE.getName()),null);
        } catch (Exception e) {
            e.printStackTrace();
            // 系统异常
            return this.warpObject(new ResponseInfo(ResponseMessage.RESULT_FAIL_SYSTEM.getIndex(), ResponseMessage.RESULT_FAIL_SYSTEM.getName()),null);
        }
    }

   
    /**
     * @Title: refreshAuthenticationToken4Mobile-old new-refreshAuthToken4Mobile
     * @Description: APP设备刷新token，心跳
     * @return 异常
     */
    @ApiOperation(value = "刷新令牌")
    @RequestMapping(value = "/refresh-token", method = RequestMethod.GET)
    public ResponseInfo refreshToken() {
        String token = SpringMVCHelper.getRequest().getHeader(jwtConfig.getHeader());
        String realToken = token.startsWith(jwtConfig.getTokenHead())?StringUtils.substringAfterLast(token, jwtConfig.getTokenHead()):token;
        String refreshedToken = jwtUtil.refreshToken(realToken);
        return this.warpObject(new JwtAuthResponse(refreshedToken));
    }

    
    /**
     * @Title: logout
     * @Description: 退出登录
     * @return 异常
     */
    @ApiOperation(value = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseInfo logout() {
        SecurityHelper.logout(SpringMVCHelper.getRequest());
        return this.warpObject(new ResponseInfo(ResponseMessage.RESULT_SUSSECC.getIndex(), ResponseMessage.RESULT_SUSSECC.getName()),null);
    }

   

}
