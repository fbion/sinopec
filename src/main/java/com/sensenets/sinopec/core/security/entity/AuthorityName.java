package com.sensenets.sinopec.core.security.entity;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: AuthorityName
 * @Description: 权限常量
 * @author xupengtao
 * @date 2016年6月8日 下午2:05:16
 *
 */
public enum AuthorityName {

    /**
     * 超级管理员用户
     */
    ROLE_PLATFORM_SUPER("超级管理员用户", "ROLE_PLATFORM_SUPER"),
    /**
     * 系统管理员用户
     */
    ROLE_PLATFORM("系统管理员用户", "ROLE_PLATFORM"),

    /**
     * 普通用户
     */
    ROLE_PLATFORM_COMMON("普通用户", "ROLE_PLATFORM_COMMON"),

    /**
     * 下级平台用户
     */
    ROLE_SUB_PLATFORM("下级平台用户", "ROLE_SUB_PLATFORM"),

    /**
     * 组合设备用户(本地)
     */
    ROLE_COMBINED("组合设备用户(本地)", "ROLE_COMBINED"),

    /**
     * 组合设备用户(中心)
     */
    ROLE_COMBINED_CENTER("组合设备用户(中心)", "ROLE_COMBINED_CENTER"),

    /**
     * 一体机用户
     */
    ROLE_AIO("立式设备用户", "ROLE_AIO"),

    /**
     * 台式设备用户
     */
    ROLE_DESKTOP("台式设备用户", "ROLE_DESKTOP"),

    /**
     * 手持设备用户
     */
    ROLE_HANDHELD("手持设备用户", "ROLE_HANDHELD"),

    /**
     * 闸机用户
     */
    ROLE_GATE("闸机用户", "ROLE_GATE"),

    /**
     * 手机APP普通用户
     */
    ROLE_MOBILE_CONSUMER("手机APP普通用户", "ROLE_MOBILE_CONSUMER"),

    /**
     * 手机APP管理员用户
     */
    ROLE_MOBILE_ADMIN("手机APP管理员用户", "ROLE_MOBILE_ADMIN"),

    /**
     * SenseId身份验证一体机
     */
    ROLE_SENSE_ID("SenseID用户", "ROLE_SENSE_ID"),

    /**
     * 第三方用户
     */
    ROLE_THRID_PARTY("第三方用户", "ROLE_THRID_PARTY");

    /**
     * 成员变量name
     */
    private String name;

    /**
     * 成员变量index
     */
    private String index;

    /**
     * 创建一个新的实例 AuthorityName.
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param name
     *            String
     * @param index
     *            String
     */
    AuthorityName(String name, String index) {
        this.name = name;
        this.index = index;
    }

    /**
     * @Title: getName
     * @Description: getName
     * @param index
     *            String
     * @return String
     */
    public static String getName(String index) {
        for (AuthorityName c : AuthorityName.values()) {
            if (StringUtils.equals(c.getIndex(), index)) {
                return c.name;
            }
        }
        return null;
    }

    /**
     * @Title: getIndex
     * @Description: 根据名字获取序号
     * @param name
     *            名字
     * @return int
     */
    public static String getIndex(String name) {
        for (AuthorityName c : AuthorityName.values()) {
            if (StringUtils.equals(c.getName(), name)) {
                return c.index;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
