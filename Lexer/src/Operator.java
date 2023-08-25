public class Operator extends Token {
    private String symbol;
    
    public Operator(Tag tag, String symbol) {
        super(tag);
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString() {
        return "Operator{" +
               "tag=" + getTag() +
               ", symbol='" + symbol + '\'' +
               '}';
    }
}
