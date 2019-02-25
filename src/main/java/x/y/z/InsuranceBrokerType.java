package x.y.z;

public enum InsuranceBrokerType {

    QUESTION("???????", "???????"),

    INSURER("INSURER", "Insurer"),

    BROKER("BROKER", "Broker");

    /** The label. */
    private final String value;
    private final String documentText;

    private InsuranceBrokerType(String value, String documentText) {
        this.documentText = documentText;
        this.value = value;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return value;
    }

    public static InsuranceBrokerType fromString(String value) {
        if(value == null || value.trim().equals("")) {
            return null;
        } else {
            return InsuranceBrokerType.valueOf(value);
        }
    }

    public String getDocumentText() {
        return documentText;
    }

}
