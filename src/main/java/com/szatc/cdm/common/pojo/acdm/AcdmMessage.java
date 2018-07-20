package com.szatc.cdm.common.pojo.acdm;

import com.google.gson.annotations.SerializedName;
import com.szatc.cdm.common.pojo.acdm.flyque.Flydepque;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

/**
 * ACDM报文实体
 *
 * @author liuweijian
 * @date 2017/12/30
 */
public class AcdmMessage {

    public static class Header {
        private String type;
        private String stype;
        private String sndr;
        private Calendar ddtm;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getSndr() {
            return sndr;
        }

        public void setSndr(String sndr) {
            this.sndr = sndr;
        }

        public Calendar getDdtm() {
            return ddtm;
        }

        public void setDdtm(Calendar ddtm) {
            this.ddtm = ddtm;
        }
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    //不序列化
    protected    Object body;

    private Header header;
    @Valid
    @SerializedName("body")
    private  List  bodys;

    public AcdmMessage(Header header, List bodys) {
        this.header = header;
        this.bodys = bodys;
    }

    public AcdmMessage(){

    }
    public AcdmMessage(Header header, Object body){
        this.header = header;
        this.body =body;
    }

    public List getBodys() {
        return bodys;
    }

    public void setBodys(List bodys) {
        this.bodys = bodys;
    }


    public void   buildBodys(Flydepque entity){
        if(body==null)
            return;

    }
}