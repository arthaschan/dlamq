package com.szatc.cdm.convert;

import com.szatc.cdm.common.constant.AcdmStateEnum;
import com.szatc.cdm.common.constant.EnumState;

import java.util.ArrayList;
import java.util.List;

/**
 * 航班状态转换工具
 *
 * @author liuweijian
 * @version 2017/11/23.
 */
public class StateConvertor {

    private static final int INT_BIT_LEN = 32;

    /**
     * 将cdm报文的状态转换为acdm接受的报文状态
     * @param strCdmState cdm状态
     * @return acdm状态
     */
    public static String stateConvert(String strCdmState) {
        int cdmState = Integer.valueOf(strCdmState);
        //存储该航班所有状态
        List<EnumState> stateList = new ArrayList<EnumState>();

        //将cdm状态的每一[二进制位]按位与
        for (int i = 0; i < INT_BIT_LEN; i++) {
            /*
            将会得到的十进制数的二进制表示为：类推
                0b00000000000000000000000000000001
                0b00000000000000000000000000000010
                0b00000000000000000000000000000100
                0b00000000000000000000000000001000
                ......
                0b10000000000000000000000000000000
             */
            int state = (int) Math.pow(2, i);
            if ((cdmState & state) == state) {
                for (EnumState enumState : EnumState.values()) {
                    if (state == enumState.getValue()) {
                        stateList.add(enumState);
                    }
                }
            }
        }

        /*
        确定航班唯一的状态:
            航班在:返航、备降、取消，三个状态不相容
            优先级:（返航、备降、取消） > 落地 > 起飞 > 计划
         */
        if (stateList.contains(EnumState.RTN)) {
            return String.valueOf(AcdmStateEnum.RTN.getValue());
        }
        if (stateList.contains(EnumState.ALTN)) {
            return String.valueOf(AcdmStateEnum.ALTN.getValue());
        }
        //以下两种取消都视为AcdmEnumState.CNL
        if (stateList.contains(EnumState.PLN_CNL)) {
            return String.valueOf(AcdmStateEnum.CNL.getValue());
        }
        if (stateList.contains(EnumState.CNL)) {
            return String.valueOf(AcdmStateEnum.CNL.getValue());
        }
        if (stateList.contains(EnumState.ARR)) {
            return String.valueOf(AcdmStateEnum.ARR.getValue());
        }
        if (stateList.contains(EnumState.DEP)) {
            return String.valueOf(AcdmStateEnum.DEP.getValue());
        }
        if (stateList.contains(EnumState.PLN)) {
            return String.valueOf(AcdmStateEnum.PLN.getValue());
        }

        return null;
    }
}
