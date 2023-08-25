public class HexConstant extends Token {
    private String value;
    
    public HexConstant(String value) {
        super(Tag.HEX_CONSTANT);
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
               '}';
    }
}
