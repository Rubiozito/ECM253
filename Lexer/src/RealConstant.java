public class RealConstant extends Token {
    private double value;
    
    public RealConstant(double value) {
        super(Tag.REAL_CONSTANT);
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
               '}';
    }
}
