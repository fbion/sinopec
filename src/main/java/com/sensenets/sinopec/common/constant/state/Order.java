package com.sensenets.sinopec.common.constant.state;

/**
  * @ClassName: Order
  * @Description: 数据库排序
  * @author think
  * @date 2018年8月6日 下午3:15:06
  *
  */
public enum Order {

    ASC("asc"), DESC("desc");

    private String des;

    Order(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
