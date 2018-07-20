package com.szatc.cdm.common.constant;

/**
 * 大连消息大类枚举
 *
 * @author liuweijian
 * @version 2017/12/31
 */
public   class  DlSubTypeEnum {

    //开始登机、结束登机、上轮档、撤轮档、机位、机号变更

    public enum DlGosSubTypeEnum {

        /**
         * 开始登机
         */
        BOR("BOR"),
        /**
         * 结束登机
         */
        POK("POK"),
        /**
         * 上轮档
         */
        BLOCKUPTIME("BLOCKUPTIME"),
        /**
         * 撤轮档
         */
        BLOCKDOWNTIME("BLOCKDOWNTIME");


        private String state;

        DlGosSubTypeEnum(String state) {
            this.state = state;
        }

        public String getValue() {
            return state;
        }

        @Override
        public String toString() {
            return state;
        }

    }

    public enum DlDyFlightSubTypeEnum {

        /**
         *新增航班
         */
        ADD("ADD"),
        /**
         * 修改航班
         */
        MODIFY("MODIFY"),
        /**
         * 请求应答
         */
        DELETE("DELETE"),
        /**
         * 停机位变更
         */
        CRAFTSEAT("CRAFTSEAT");


        private String state;

        DlDyFlightSubTypeEnum(String state) {
            this.state = state;
        }

        public String getValue() {
            return state;
        }

        @Override
        public String toString() {
            return state;
        }

    }
//    public enum DlBaseSubTypeEnum {//
//    }

//    public enum DlRequestSubTypeEnum {
//    }


//    public enum DlMsgSubTypeEnum {
//    }


}


