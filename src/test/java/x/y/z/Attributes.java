package x.y.z;

public enum Attributes {
    
    ATTR1("attr1"),
    ATTR2("attr2"),
    ATTR3("attr3"),
    CATEGORY("some category");
    
    private String value;

    private Attributes(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
