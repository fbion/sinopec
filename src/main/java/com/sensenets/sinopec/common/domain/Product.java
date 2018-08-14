package com.sensenets.sinopec.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: Product
 * @Description: demo
 * @author think
 * @date 2018年8月5日 上午11:33:08
 *
 */
@ApiModel(value="Product",description="商品实体对象")
public class Product {

    @ApiModelProperty(value="商品id",name="id")
    private Integer id;

    @ApiModelProperty(value="商品名称",name="name")
    private String name;

    @ApiModelProperty(value="id数组",hidden=true)
    private String[] ids;


    public Product(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
      * 创建一个新的实例 Product. 
      * <p>Title: </p>
      * <p>Description: </p>
      * @param id
      * @param name
      */
    public Product(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
        
    
}
