public class RealConstant extends Token {
    private double value;
    
    public RealConstant(double value, int line, int column) {
        super(Tag.REAL_CONSTANT, line, column);
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "RealConstant{" +
               "tag=" + getTag() +
               ", value=" + value +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}