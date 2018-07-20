package com.szatc.cdm.common.pojo.acdm.selfdefine;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author liuweijian
 * @version 2017/12/23.
 */
public class DelayCodeType {
    @NotBlank(message = "必须有值")
    @Pattern(regexp = "(天气|公司|空管|机场|联检|油料|离港系统|旅客|军事活动|公共安全)",
        message = "非有效取值范围")
    private String delayReason;
    private String delayInfo;

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public String getDelayInfo() {
        return delayInfo;
    }

    public void setDelayInfo(String delayInfo) {
        this.delayInfo = delayInfo;
    }
}
