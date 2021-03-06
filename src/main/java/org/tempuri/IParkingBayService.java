
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IParkingBayService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IParkingBayService {


    /**
     * 
     * @param xmlMessage
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ReceiveParkingBayFromCdm", action = "http://tempuri.org/IParkingBayService/ReceiveParkingBayFromCdm")
    @WebResult(name = "ReceiveParkingBayFromCdmResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ReceiveParkingBayFromCdm", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ReceiveParkingBayFromCdm")
    @ResponseWrapper(localName = "ReceiveParkingBayFromCdmResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ReceiveParkingBayFromCdmResponse")
    public String receiveParkingBayFromCdm(
        @WebParam(name = "xmlMessage", targetNamespace = "http://tempuri.org/")
        String xmlMessage);

}
