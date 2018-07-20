package com.szatc.cdm.common.pojo.acdm.basicdata;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/**
 * 停机位信息
 *
 * @author liuweijian
 * @date 2017/12/31
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Stopsite {
    @NotNull
    @Length(max = 10)
    private String code;
    @Length(max = 10)
    private String soapStatus = "0";
    @Length(max = 50)
    @Pattern(regexp = "(1|2)", message = "非有效取值范围")
    private String type;
    @Length(max = 50)
    @Pattern(regexp = "(0|1|2)", message = "非有效取值范围")
    private String limitType;
    @Length(max = 50)
    @Pattern(regexp = "(1|2|3|4)", message = "非有效取值范围")
    private String level;
    @Length(max = 50)
    @Pattern(regexp = "(1|2|3|4|5)", message = "非有效取值范围")
    private String soapUse;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSoapStatus() {
        return soapStatus;
    }

    public void setSoapStatus(String soapStatus) {
        this.soapStatus = soapStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSoapUse() {
        return soapUse;
    }

    public void setSoapUse(String soapUse) {
        this.soapUse = soapUse;
    }
}
