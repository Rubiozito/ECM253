public class IntConstant extends Token {
    private int value;
    
    public IntConstant(int value, int line, int column) {
        super(Tag.INTEGER_CONSTANT, line, column);
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "IntConstant{" +
               "tag=" + getTag() +
               ", value=" + value +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}
