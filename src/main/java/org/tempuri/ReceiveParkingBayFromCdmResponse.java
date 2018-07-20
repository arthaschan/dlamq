
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**

 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "receiveParkingBayFromCdmResult"
})
@XmlRootElement(name = "ReceiveParkingBayFromCdmResponse")
public class ReceiveParkingBayFromCdmResponse {

    @XmlElementRef(name = "ReceiveParkingBayFromCdmResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiveParkingBayFromCdmResult;

    /**
     * ��ȡreceiveParkingBayFromCdmResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiveParkingBayFromCdmResult() {
        return receiveParkingBayFromCdmResult;
    }

    /**
     * ����receiveParkingBayFromCdmResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiveParkingBayFromCdmResult(JAXBElement<String> value) {
        this.receiveParkingBayFromCdmResult = value;
    }

}
