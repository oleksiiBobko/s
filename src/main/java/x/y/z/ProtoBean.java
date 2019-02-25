package x.y.z;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;;

@Component
@Scope("prototype")
public class ProtoBean {

    private String sample = "sample";

    @Autowired
    private InjectedBean bean;

    public ProtoBean() {
        System.err.println("created: " + getClass());
    }

    public InjectedBean getBean() {
        return bean;
    }

    public String getSample() {
        return sample;
    }

}
