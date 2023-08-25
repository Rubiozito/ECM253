public class OctalConstant extends Token {
    private String value;
    
    public OctalConstant(String value) {
        super(Tag.OCTAL_CONSTANT);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "OctalConstant{" +
               "tag=" + getTag() +
               ", value='" + value + '\'' +
               '}';
    }
}
