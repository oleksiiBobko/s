

package x.y.z;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private String sample = "sample";

    @Autowired
    private ObjectFactory<ProtoBean> factory;

    public static final String EMPTY = "";

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Lookup
    public ProtoBean getProto() {
        return null;
    }

}


