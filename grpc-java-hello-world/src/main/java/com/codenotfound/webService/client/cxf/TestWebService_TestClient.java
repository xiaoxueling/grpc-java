
package com.codenotfound.webService.client.cxf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWebService_TestClient {

    private static final Logger logger = LoggerFactory.getLogger(TestWebService_TestClient.class);

    public static void main(String[] args) {

        TestWebService_Service ss = new TestWebService_Service();
        TestWebService port = ss.getTestWebServiceImplPort();

        String response= port.sayHelloWord(" cxf WebService Client");

        logger.info("================> {}",response);
    }
}
