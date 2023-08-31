public class Operator extends Token {
    private String symbol;
    
    public Operator(Tag tag, String symbol, int line, int column) {
        super(tag, line, column);
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
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}