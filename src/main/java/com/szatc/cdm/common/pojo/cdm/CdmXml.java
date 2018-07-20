package com.szatc.cdm.common.pojo.cdm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ACDM报文实体
 *
 * @author liuweijian
 * @date 2017/12/30
 */
@XmlRootElement(name = "CDMMessage")
public class CdmXml {

    private CdmHeader header;

    private Object  body;

    public CdmXml(CdmHeader header, Object body) {
        this.header = header;
        this.body = body;
    }

    public CdmXml(){

    }

    @XmlElement(name="header")
    public CdmHeader getHeader() {
        return header;
    }

    public void setHeader(CdmHeader header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}