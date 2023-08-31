public class StringLiteral extends Token {
    private String value;
    
    public StringLiteral(String value, int line, int column) {
        super(Tag.STRING, line, column);
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
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}