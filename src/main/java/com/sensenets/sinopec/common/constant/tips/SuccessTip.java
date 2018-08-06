package com.sensenets.sinopec.common.constant.tips;

/**
  * @ClassName: SuccessTip
  * @Description:返回给前台的成功提示
  * @author think
  * @date 2018年8月6日 下午3:15:48
  *
  */
public class SuccessTip extends Tip{
	
	public SuccessTip(){
		super.code = 200;
		super.message = "操作成功";
	}
}
