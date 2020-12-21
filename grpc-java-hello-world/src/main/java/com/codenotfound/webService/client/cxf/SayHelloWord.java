
package com.codenotfound.webService.client.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHelloWord", propOrder = {
    "data"
})
public class SayHelloWord {

    protected String data;

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }

}
