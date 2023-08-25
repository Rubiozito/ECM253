public class IntConstant extends Token {
    private int value;
    
    public IntConstant(int value) {
        super(Tag.INTEGER_CONSTANT);
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
               '}';
    }
}
