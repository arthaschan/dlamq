package com.szatc.cdm.common.pojo.dlcdm;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ACDM报文实体
 *
 * @author liuweijian
 * @date 2017/12/30
 */
@XmlRootElement(name = "MSG")
public class DlXml {

    private DlHeader header;

    private Object  body;

    public DlXml(DlHeader header, Object body) {
        this.header = header;
        this.body = body;
    }

    public DlXml(){

    }

    @XmlElement(name="META")
    public DlHeader getHeader() {
        return header;
    }

    public void setHeader(DlHeader header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}