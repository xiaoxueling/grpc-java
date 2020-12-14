package com.codenotfound.webService.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.1
 * 2020-12-14T17:28:12.705+08:00
 * Generated source version: 3.4.1
 *
 */
@WebService(targetNamespace = "http://webService.codenotfound.com/", name = "testWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface TestWebService {

    @WebMethod
    @RequestWrapper(localName = "sayHelloWord", targetNamespace = "http://webService.codenotfound.com/", className = "com.codenotfound.webService.client.SayHelloWord")
    @ResponseWrapper(localName = "sayHelloWordResponse", targetNamespace = "http://webService.codenotfound.com/", className = "com.codenotfound.webService.client.SayHelloWordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayHelloWord(

        @WebParam(name = "data", targetNamespace = "")
        java.lang.String data
    );
}
