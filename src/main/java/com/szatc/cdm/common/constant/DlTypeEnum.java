package com.szatc.cdm.common.constant;

/**
 * 大连消息大类枚举
 *
 * @author liuweijian
 * @version 2017/12/31
 */
public enum DlTypeEnum {

    /**航班保障*/
    GOS("GOS"),
    /**航班动态*/
    DYNFLIGHT ("DYNFLIGHT"),
    /**基础数据*/
    BASE ("BASE"),
    /**请求应答*/
    REQUEST ("REQUEST"),
    /**及时通讯*/
    IMSG ("IMSG");


    private String state;

    DlTypeEnum(String state) {
        this.state = state;
    }

    public String getValue() {return state;}

    @Override
    public String toString() {
        return  state ;
    }
}
