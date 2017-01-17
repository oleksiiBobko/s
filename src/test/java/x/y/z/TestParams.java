package x.y.z;

import java.util.Arrays;
import java.util.Collection;

public class TestParams {
    public static final String PARAMS_METHOD_NAME = "params";
    
    public static Collection<Object[]> params() {
        Collection<Object[]> games = Arrays.asList(new Object[][] { 
                { Attributes.ATTR1, Attributes.CATEGORY },
                { Attributes.ATTR2, Attributes.CATEGORY },
                { Attributes.ATTR3, Attributes.CATEGORY },
                });
        return games;

    }

    
}
