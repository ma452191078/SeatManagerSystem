
package com.sdl.seatms.project.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sdl.seatms.project.webservice package. 
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

    private final static QName _GetPersonListDate_QNAME = new QName("http://transfer.server.webServices.hr.com", "date");
    private final static QName _GetPersonListResponseReturn_QNAME = new QName("http://transfer.server.webServices.hr.com", "return");
    private final static QName _GetParaListParaTypeCode_QNAME = new QName("http://transfer.server.webServices.hr.com", "para_type_code");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sdl.seatms.project.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonList }
     * 
     */
    public GetPersonList createGetPersonList() {
        return new GetPersonList();
    }

    /**
     * Create an instance of {@link GetPersonListResponse }
     * 
     */
    public GetPersonListResponse createGetPersonListResponse() {
        return new GetPersonListResponse();
    }

    /**
     * Create an instance of {@link GetParaList }
     * 
     */
    public GetParaList createGetParaList() {
        return new GetParaList();
    }

    /**
     * Create an instance of {@link GetParaListResponse }
     * 
     */
    public GetParaListResponse createGetParaListResponse() {
        return new GetParaListResponse();
    }

    /**
     * Create an instance of {@link GetDeptList }
     * 
     */
    public GetDeptList createGetDeptList() {
        return new GetDeptList();
    }

    /**
     * Create an instance of {@link GetDeptListResponse }
     * 
     */
    public GetDeptListResponse createGetDeptListResponse() {
        return new GetDeptListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://transfer.server.webServices.hr.com", name = "date", scope = GetPersonList.class)
    public JAXBElement<String> createGetPersonListDate(String value) {
        return new JAXBElement<String>(_GetPersonListDate_QNAME, String.class, GetPersonList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://transfer.server.webServices.hr.com", name = "return", scope = GetPersonListResponse.class)
    public JAXBElement<String> createGetPersonListResponseReturn(String value) {
        return new JAXBElement<String>(_GetPersonListResponseReturn_QNAME, String.class, GetPersonListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://transfer.server.webServices.hr.com", name = "para_type_code", scope = GetParaList.class)
    public JAXBElement<String> createGetParaListParaTypeCode(String value) {
        return new JAXBElement<String>(_GetParaListParaTypeCode_QNAME, String.class, GetParaList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://transfer.server.webServices.hr.com", name = "return", scope = GetParaListResponse.class)
    public JAXBElement<String> createGetParaListResponseReturn(String value) {
        return new JAXBElement<String>(_GetPersonListResponseReturn_QNAME, String.class, GetParaListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://transfer.server.webServices.hr.com", name = "return", scope = GetDeptListResponse.class)
    public JAXBElement<String> createGetDeptListResponseReturn(String value) {
        return new JAXBElement<String>(_GetPersonListResponseReturn_QNAME, String.class, GetDeptListResponse.class, value);
    }

}
