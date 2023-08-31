public class HexConstant extends Token {
    private String value;
    
    public HexConstant(String value, int line, int column) {
        super(Tag.HEX_CONSTANT, line, column);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "HexConstant{" +
               "tag=" + getTag() +
               ", value='" + value + '\'' +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}
