
package com.codenotfound.webService.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.1
 * 2020-12-14T17:28:12.664+08:00
 * Generated source version: 3.4.1
 *
 */
public final class TestWebService_TestWebServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.webService.codenotfound.com/", "testWebService");

    private TestWebService_TestWebServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = TestWebService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        TestWebService_Service ss = new TestWebService_Service(wsdlURL, SERVICE_NAME);
        TestWebService port = ss.getTestWebServiceImplPort();

        {
        System.out.println("Invoking sayHelloWord...");
        java.lang.String _sayHelloWord_data = "";
        java.lang.String _sayHelloWord__return = port.sayHelloWord(_sayHelloWord_data);
        System.out.println("sayHelloWord.result=" + _sayHelloWord__return);


        }

        System.exit(0);
    }

}
