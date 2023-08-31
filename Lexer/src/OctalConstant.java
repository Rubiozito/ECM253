public class OctalConstant extends Token {
    private String value;
    
    public OctalConstant(String value, int line, int column) {
        super(Tag.OCTAL_CONSTANT, line, column);
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
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}
