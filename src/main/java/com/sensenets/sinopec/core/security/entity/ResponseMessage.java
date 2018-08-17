package com.sensenets.sinopec.core.security.entity;
/**
 * @ClassName: ReturnType
 * @Description: 返回结果类型以及具体message
 * @author xiechunquan
 * @date 2016年9月9日
 *
 */
public enum ResponseMessage {

    /**
     * 成功
     */
    RESULT_SUSSECC("成功", 200),

    /**
     * 密码错误
     */
    RESULT_FAIL_VERIFICATION("密码错误", 100001),

    /**
     * 用户角色不可登录该设备
     */
    RESULT_FAIL_ROLE("用户角色不可登录该设备", 100002),

    /**
     * 已绑定其他设备
     */
    RESULT_FAIL_MACHINE("已绑定其他设备", 100003),

    /**
     * 系统异常
     */
    RESULT_FAIL_SYSTEM("系统异常", 100004),

    /**
     * 用户名或密码错误
     */
    RESULT_FAIL_NAME("用户名或密码错误", 100005),

    /**
     * 原密码错误
     */
    RESULT_FAIL_ORIGIN_PWD("原密码错误", 100006),

    /**
     * 设备的机器码不能为空
     */
    RESULT_FAIL_MACHINE_CODE("设备的机器码不能为空", 100007),

    /**
     * 账户过期，登入失败
     */
    EXPIRE_TIME("账户过期，登入失败", 100008),

    /**
     * 账户被人为禁用，登入失败
     */
    ACCOUNT_DISABLE("账户被禁用，登入失败", 100009),

    /**
     * 用户不存在，请重新登陆
     */
    RESULT_FAIL_USER_NOT_EXIST("用户不存在或被禁用，请重新登录", 100010),


    /**
     * 刷脸认证失败
     */
    RESULT_FACE_LOGIN_FAIL("认证失败", 100012);

    /**
     * 枚举名
     */
    private String name;
    /**
     * 枚举编号
     */
    private int index;

    ResponseMessage(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * 普通方法
     * 
     * @Title: getName
     * @Description: 构造方法
     * @param index
     *            枚举序号
     * @return 返回值
     */
    public static String getName(int index) {
        for (ResponseMessage c : ResponseMessage.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    /**
     * @Title: getIndex
     * @Description: 根据名字获取枚举序号
     * @param name
     *            名字
     * @return 枚举序号
     */
    public static int getIndex(String name) {
        for (ResponseMessage c : ResponseMessage.values()) {
            if (c.getName().equals(name)) {
                return c.index;
            }
        }
        return RESULT_SUSSECC.index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
