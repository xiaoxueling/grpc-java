package com.codenotfound.webService.client.axis2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWebServices_TestClient {

    private static final Logger logger = LoggerFactory.getLogger(TestWebServices_TestClient.class);

    public static void main(String[] args) {
        try {
            TestWebServiceStub testWebServiceStub=new TestWebServiceStub();

            //没有配置 soapAction 的解决方法
            //testWebServiceStub._getServiceClient().getOptions().setProperty(org.apache.axis2.Constants.Configuration.DISABLE_SOAP_ACTION, true);

            TestWebServiceStub.SayHelloWordE sayHelloWord=new TestWebServiceStub.SayHelloWordE();

            TestWebServiceStub.SayHelloWord param=new TestWebServiceStub.SayHelloWord();
            param.setData(" axis2 WebService Client");

            sayHelloWord.setSayHelloWord(param);

            TestWebServiceStub.SayHelloWordResponse response= testWebServiceStub.sayHelloWord(sayHelloWord).getSayHelloWordResponse();

            logger.info("================> {}",response.get_return());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
