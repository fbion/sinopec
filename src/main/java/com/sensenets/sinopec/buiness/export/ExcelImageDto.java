/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月13日 下午12:44:33
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.export;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @ClassName: ExcelImageDto
  * @Description: excel图片对象
  * @author think
  * @date 2018年9月13日 下午12:44:33
  *
  */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelImageDto {
  
    /**
      * @Fields showName : 展示名称
      */
    private String showName;
    
    /**
      * @Fields imageBasePath : 图片基本路径
      */
    private String imageBasePath;
    
    /**
      * @Fields imageFileName : 图片文件名称
      */
    private String imageFileName;
    
}
