package com.sensenets.sinopec.common.enums;


/**
  * @ClassName: BizExceptionEnum
  * @Description: 所有业务异常的枚举
  * @author think
  * @date 2018年8月6日 下午3:00:51
  *
  */
public enum BizExceptionEnum {

    /*****权限认证模块*****/
	RIGHT_AUTH_ERROR_TOKEN_EXPIRED(100001,"认证令牌已过期"),
	RIGHT_AUTH_ERROR_TOKEN_ERROR(100002,"认证令牌错误"),
	
	/*****移动数据采集模块*****/
    MOBILE_COLLECT_ERROR_TIME_PARAMS_NULL(200001,"采集时间的参数不能为空"),
    MOBILE_COLLECT_ERROR_TYPE_PARAMS_NULL(200002,"采集类型的参数不能为空"),
    MOBILE_COLLECT_ERROR_NAME_PARAMS_NULL(200003,"请选择采集名称"),
    MOBILE_COLLECT_ERROR_STATION_NAME_PARAMS_NULL(200004,"请选择油站名称"),
    MOBILE_COLLECT_ERROR_ID_PARAMS_ERROR(200005,"传入的参数有误"),
    MOBILE_COLLECT_TIP_NOT_UPDATE(200006,"您未修改任何参数，将不做任何更新！"),
    MOBILE_COLLECT_ERROR_ID_PARAMS_NULL(200007,"采集记录id不能为空"),
    MOBILE_COLLECT_ERROR_TASK_UNFINISH(200008,"采集分析还未完成"),
    MOBILE_COLLECT_ERROR_EXPORT_FAIL(200009,"采集分析导出报表异常"),
    MOBILE_COLLECT_ERROR_REPOS_NOT_EXIST(200010,"采集分析提交的参数异常"),
    MOBILE_COLLECT_ERROR_DOWNLOAD_PARAM(200011,"下载导出文件提交的参数异常"),
    MOBILE_COLLECT_ERROR_NO_RIGHT_DOWNLOAD(200012,"您暂无下载该文件的权限"),
	
    /*****设备管理模块*****/
    SENSOR_ERROR_NULL(300001,"暂无相关采集设备或油站摄相机,不能添加任务"),
	
    /*****移动数据采集统计车流量模块*****/
    MOBILE_COLLECT_FLOW_INSERT_ERROR(400001,"插入车流量统计记录失败"),
    
    /*****移动数据采集统计车辆类型模块*****/
    MOBILE_COLLECT_VEHCLE_INSERT_ERROR(500001,"插入车类型统计记录失败"),
    
    
    /*****车辆排队模块*****/
    VEHICLE_QUEUE_REPOS_ID_PARAM_ERROR(600001,"车辆排队采集名称错误"),
   
    
	/**
	 * 字典
	 */
	DICT_EXISTED(400,"字典已经存在"),
	ERROR_CREATE_DICT(500,"创建字典失败"),
	ERROR_WRAPPER_FIELD(500,"包装字典属性失败"),


	/**
	 * 文件上传
	 */
	FILE_READING_ERROR(400,"FILE_READING_ERROR!"),
	FILE_NOT_FOUND(400,"FILE_NOT_FOUND!"),
	UPLOAD_ERROR(500,"上传图片出错"),

	/**
	 * 权限和数据问题
	 */
	DB_RESOURCE_NULL(400,"数据库中没有该资源"),
	NO_PERMITION(405, "权限异常"),
	REQUEST_INVALIDATE(400,"请求数据格式不正确"),
	INVALID_KAPTCHA(400,"验证码不正确"),
	CANT_DELETE_ADMIN(600,"不能删除超级管理员"),
	CANT_FREEZE_ADMIN(600,"不能冻结超级管理员"),
	CANT_CHANGE_ADMIN(600,"不能修改超级管理员角色"),

	/**
	 * 账户问题
	 */
	USER_ALREADY_REG(401,"该用户已经注册"),
	NO_THIS_USER(400,"没有此用户"),
	USER_NOT_EXISTED(400, "没有此用户"),
	ACCOUNT_FREEZED(401, "账号被冻结"),
	OLD_PWD_NOT_RIGHT(402, "原密码不正确"),
	TWO_PWD_NOT_MATCH(405, "两次输入密码不一致"),

	/**
	 * 错误的请求
	 */
	MENU_PCODE_COINCIDENCE(400,"菜单编号和副编号不能一致"),
	EXISTED_THE_MENU(400,"菜单编号重复，不能添加"),
	DICT_MUST_BE_NUMBER(400,"字典的值必须为数字"),
	REQUEST_NULL(400, "请求有错误"),
	SESSION_TIMEOUT(400, "会话超时"),
	SERVER_ERROR(500, "服务器异常");

	BizExceptionEnum(int code, String message) {
		this.friendlyCode = code;
		this.friendlyMsg = message;
	}
	
	BizExceptionEnum(int code, String message,String urlPath) {
		this.friendlyCode = code;
		this.friendlyMsg = message;
		this.urlPath = urlPath;
	}

	private int friendlyCode;

	private String friendlyMsg;
	
	private String urlPath;

	public int getCode() {
		return friendlyCode;
	}

	public void setCode(int code) {
		this.friendlyCode = code;
	}

	public String getMessage() {
		return friendlyMsg;
	}

	public void setMessage(String message) {
		this.friendlyMsg = message;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

}
