package com.szatc.cdm.common.pojo.acdm.selfdefine;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liuweijian
 * @version 2017/12/24.
 */
public class ReasonType {
    @NotBlank(message = "必须有值")
    private String code;
    private String Information;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }
}
