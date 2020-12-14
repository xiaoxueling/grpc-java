package com.codenotfound.webService.impl;

import com.codenotfound.webService.ITestWebService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(serviceName = "testWebService",endpointInterface = "com.codenotfound.webService.ITestWebService")
public class TestWebServiceImpl implements ITestWebService {

    @Override
    public String helloWord(String requestData) {
        return "Hello "+requestData;
    }
}
