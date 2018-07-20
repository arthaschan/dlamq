package com.szatc.cdm.common.constant;

/**
 * Acdm航班状态枚举
 * 对状态的增删应该同步修改pojo中的约束
 *
 * @author liuweijian
 * @version 2017/12/31
 */
public enum AcdmStateEnum {

    /**计划*/
    PLN (0),
    /**起飞*/
    DEP (1),
    /**到达*/
    ARR (2),
    /**取消*/
    CNL (3),
    /**备降*/
    ALTN (5),
    /**返航*/
    RTN (6);

    private int state;

    AcdmStateEnum(int state) {
        this.state = state;
    }

    public int getValue() {return state;}

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
