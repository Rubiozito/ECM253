public class StringLiteral extends Token {
    private String value;
    
    public StringLiteral(String value) {
        super(Tag.STRING);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "StringLiteral{" +
               "tag=" + getTag() +
               ", value='" + value + '\'' +
               '}';
    }
}
