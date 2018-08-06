package com.sensenets.sinopec.common.domain;

/**
 * @ClassName: Product
 * @Description: demo
 * @author think
 * @date 2018年8月5日 上午11:33:08
 *
 */
public class Product {
    
    
    private Integer id;
    
    private String name;

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
