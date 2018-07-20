package com.szatc.cdm.common.constant;

/**
 * Mime type
 *
 * @author Ken
 * @date 2017/12/24
 */
public enum ContentTypeEnum {

    XML("application/xml"),
    JSON("application/json");

    private String type;

    private ContentTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
