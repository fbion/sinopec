/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月30日 上午9:59:51
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
  * @ClassName: RepoIdDto
  * @Description: 存放组织机构 id和查询主键
  * @author think
  * @date 2018年8月30日 上午9:59:51
  *
  */
@Data
@AllArgsConstructor
public class RepoIdDto {

    private Long id;
    
    private String repoId;  
    
    private String repoName; 
    
    private Short repoLevel;
    
    
    
}
