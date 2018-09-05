/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月5日 下午2:07:37
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @ClassName: ImageDto
  * @Description: 原始记录图片对象
  * @author think
  * @date 2018年9月5日 下午2:07:37
  *
  */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto implements Serializable{
    
    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = -5121020376265436893L;


    private String imageId;
    
    
    private String sourceImageUrl ;
    
    
    private String featureImageUrl;

}
