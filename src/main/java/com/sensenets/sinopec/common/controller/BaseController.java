package com.sensenets.sinopec.common.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.common.domain.ResponsePage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.sensenets.sinopec.common.constant.state.Order;
import com.sensenets.sinopec.common.constant.tips.SuccessTip;
import com.sensenets.sinopec.common.domain.ResponseInfo;
import com.sensenets.sinopec.common.page.PageInfoBT;
import com.sensenets.sinopec.common.page.PageReq;
import com.sensenets.sinopec.common.warpper.BaseControllerWarpper;
import com.sensenets.sinopec.common.warpper.CommonControllerWarpper;
import com.sensenets.sinopec.core.support.FileUtil;
import com.sensenets.sinopec.core.support.HttpKit;
import com.sensenets.sinopec.core.support.ToolUtil;

public class BaseController {

    protected static String SUCCESS = "SUCCESS";
    protected static String ERROR = "ERROR";

    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();

    protected HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

    protected HttpSession getSession() {
        return HttpKit.getRequest().getSession();
    }

    protected HttpSession getSession(Boolean flag) {
        return HttpKit.getRequest().getSession(flag);
    }

    protected String getPara(String name) {
        return HttpKit.getRequest().getParameter(name);
    }

    protected void setAttr(String name, Object value) {
        HttpKit.getRequest().setAttribute(name, value);
    }

    protected Integer getSystemInvokCount() {
        return (Integer) this.getHttpServletRequest().getServletContext().getAttribute("systemCount");
    }

    /**
     * 把service层的分页信息，封装为bootstrap table通用的分页封装
     */
    protected <T> PageInfoBT<T> packForBT(List<T> page) {
        return new PageInfoBT<T>(page);
    }

    public PageReq defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        PageReq pageReq = new PageReq(limit, offset, sort, order);
        if (ToolUtil.isEmpty(sort)) {
            pageReq.setOpenSort(false);
        } else {
        	pageReq.setOpenSort(true);
            if (Order.ASC.getDes().equals(order)) {
                pageReq.setAsc(true);
            } else {
                pageReq.setAsc(false);
            }
        }
        return pageReq;
    }
  
    protected ResponseInfo warpObject(Object obj) {
        ResponseInfo responseInfo = new ResponseInfo();
        BaseControllerWarpper warpper = new CommonControllerWarpper(obj);
        responseInfo.setData(warpper.warp());
        return responseInfo;
    }

    protected <T> ResponseInfo warpPageObject( PageInfo<T> page) {
        ResponseInfo responseInfo = new ResponseInfo();
        ResponsePage<T> response = new ResponsePage<T>(page.getList());
        response.setPageNumber(page.getPageNum());
        response.setPageSize(page.getPageSize());
        response.setTotal(page.getTotal());
        BaseControllerWarpper warpper = new CommonControllerWarpper(response);
        responseInfo.setData(warpper.warp());
        return responseInfo;
    }
    
    protected ResponseInfo warpObject(ResponseInfo info,Object obj) {
        if(obj!=null){
            BaseControllerWarpper warpper = new CommonControllerWarpper(obj);
            info.setData(warpper.warp());
        }
        return info;
    }

    /**
     * 删除cookie
     */
    protected void deleteCookieByName(String cookieName) {
        Cookie[] cookies = this.getHttpServletRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                Cookie temp = new Cookie(cookie.getName(), "");
                temp.setMaxAge(0);
                this.getHttpServletResponse().addCookie(temp);
            }
        }
    }

    /**
     * 返回前台文件流
     *
     * @author fengshuonan
     * @date 2017年2月28日 下午2:53:19
     */
    protected ResponseEntity<byte[]> renderFile(String fileName, String filePath) {
        byte[] bytes = FileUtil.toByteArray(filePath);
        return renderFile(fileName, bytes);
    }

    /**
     * 返回前台文件流
     *
     * @author fengshuonan
     * @date 2017年2月28日 下午2:53:19
     */
    protected ResponseEntity<byte[]> renderFile(String fileName, byte[] fileBytes) {
        String dfileName = null;
        try {
            dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(fileBytes, headers, HttpStatus.CREATED);
    }
}