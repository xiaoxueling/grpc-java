package com.codenotfound.webService;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    private Bus bus;
    private ITestWebService testWebService;

    public WebServiceConfig(Bus bus, ITestWebService testWebService) {
        this.bus = bus;
        this.testWebService = testWebService;
    }

    @Bean
    public ServletRegistrationBean<CXFServlet> cfxServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/webservices/*");
    }

    @Bean
    public Endpoint testEndpoint(){

        Endpoint endpoint=new EndpointImpl(bus,testWebService);

        endpoint.publish("/test");

        return endpoint;
    }
}
