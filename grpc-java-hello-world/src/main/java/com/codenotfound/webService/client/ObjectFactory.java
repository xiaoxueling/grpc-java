
package com.codenotfound.webService.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codenotfound.webService.client package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _SayHelloWord_QNAME = new QName("http://webService.codenotfound.com/", "sayHelloWord");
    private final static QName _SayHelloWordResponse_QNAME = new QName("http://webService.codenotfound.com/", "sayHelloWordResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codenotfound.webService.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHelloWord }
     * 
     */
    public SayHelloWord createSayHelloWord() {
        return new SayHelloWord();
    }

    /**
     * Create an instance of {@link SayHelloWordResponse }
     * 
     */
    public SayHelloWordResponse createSayHelloWordResponse() {
        return new SayHelloWordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWord }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayHelloWord }{@code >}
     */
    @XmlElementDecl(namespace = "http://webService.codenotfound.com/", name = "sayHelloWord")
    public JAXBElement<SayHelloWord> createSayHelloWord(SayHelloWord value) {
        return new JAXBElement<SayHelloWord>(_SayHelloWord_QNAME, SayHelloWord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWordResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayHelloWordResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webService.codenotfound.com/", name = "sayHelloWordResponse")
    public JAXBElement<SayHelloWordResponse> createSayHelloWordResponse(SayHelloWordResponse value) {
        return new JAXBElement<SayHelloWordResponse>(_SayHelloWordResponse_QNAME, SayHelloWordResponse.class, null, value);
    }

}
