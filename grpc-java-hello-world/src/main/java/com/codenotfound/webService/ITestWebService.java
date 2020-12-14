package com.codenotfound.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "testWebService")
public interface ITestWebService {

    @WebMethod(operationName="sayHelloWord")
    String helloWord(@WebParam(name = "data") String requestData);
}
