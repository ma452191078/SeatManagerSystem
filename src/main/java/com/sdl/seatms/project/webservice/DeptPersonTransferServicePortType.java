package com.sdl.seatms.project.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-07-30T16:37:19.811+08:00
 * Generated source version: 3.3.2
 *
 */
@WebService(targetNamespace = "http://transfer.server.webServices.hr.com", name = "DeptPersonTransferServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface DeptPersonTransferServicePortType {

    @WebMethod(action = "urn:getDeptList")
    @Action(input = "urn:getDeptList", output = "urn:getDeptListResponse")
    @RequestWrapper(localName = "getDeptList", targetNamespace = "http://transfer.server.webServices.hr.com", className = "com.sdl.seatms.project.webservice.GetDeptList")
    @ResponseWrapper(localName = "getDeptListResponse", targetNamespace = "http://transfer.server.webServices.hr.com", className = "com.sdl.seatms.project.webservice.GetDeptListResponse")
    @WebResult(name = "return", targetNamespace = "http://transfer.server.webServices.hr.com")
    public java.lang.String getDeptList()
;

    @WebMethod(action = "urn:getParaList")
    @Action(input = "urn:getParaList", output = "urn:getParaListResponse")
    @RequestWrapper(localName = "getParaList", targetNamespace = "http://transfer.server.webServices.hr.com", className = "com.sdl.seatms.project.webservice.GetParaList")
    @ResponseWrapper(localName = "getParaListResponse", targetNamespace = "http://transfer.server.webServices.hr.com", className = "com.sdl.seatms.project.webservice.GetParaListResponse")
    @WebResult(name = "return", targetNamespace = "http://transfer.server.webServices.hr.com")
    public java.lang.String getParaList(

        @WebParam(name = "para_type_code", targetNamespace = "http://transfer.server.webServices.hr.com")
        java.lang.String paraTypeCode
    );

    @WebMethod(action = "urn:getPersonList")
    @Action(input = "urn:getPersonList", output = "urn:getPersonListResponse")
    @RequestWrapper(localName = "getPersonList", targetNamespace = "http://transfer.server.webServices.hr.com", className = "com.sdl.seatms.project.webservice.GetPersonList")
    @ResponseWrapper(localName = "getPersonListResponse", targetNamespace = "http://transfer.server.webServices.hr.com", className = "com.sdl.seatms.project.webservice.GetPersonListResponse")
    @WebResult(name = "return", targetNamespace = "http://transfer.server.webServices.hr.com")
    public java.lang.String getPersonList(

        @WebParam(name = "date", targetNamespace = "http://transfer.server.webServices.hr.com")
        java.lang.String date
    );
}
