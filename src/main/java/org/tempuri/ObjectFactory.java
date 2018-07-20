
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReceiveParkingBayFromCdmResponseReceiveParkingBayFromCdmResult_QNAME = new QName("http://tempuri.org/", "ReceiveParkingBayFromCdmResult");
    private final static QName _ReceiveParkingBayFromCdmXmlMessage_QNAME = new QName("http://tempuri.org/", "xmlMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceiveParkingBayFromCdmResponse }
     * 
     */
    public ReceiveParkingBayFromCdmResponse createReceiveParkingBayFromCdmResponse() {
        return new ReceiveParkingBayFromCdmResponse();
    }

    /**
     * Create an instance of {@link ReceiveParkingBayFromCdm }
     * 
     */
    public ReceiveParkingBayFromCdm createReceiveParkingBayFromCdm() {
        return new ReceiveParkingBayFromCdm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReceiveParkingBayFromCdmResult", scope = ReceiveParkingBayFromCdmResponse.class)
    public JAXBElement<String> createReceiveParkingBayFromCdmResponseReceiveParkingBayFromCdmResult(String value) {
        return new JAXBElement<String>(_ReceiveParkingBayFromCdmResponseReceiveParkingBayFromCdmResult_QNAME, String.class, ReceiveParkingBayFromCdmResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlMessage", scope = ReceiveParkingBayFromCdm.class)
    public JAXBElement<String> createReceiveParkingBayFromCdmXmlMessage(String value) {
        return new JAXBElement<String>(_ReceiveParkingBayFromCdmXmlMessage_QNAME, String.class, ReceiveParkingBayFromCdm.class, value);
    }

}
