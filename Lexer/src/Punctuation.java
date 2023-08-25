public class Punctuation extends Token {
    private String symbol;
    
    public Punctuation(Tag tag, String symbol) {
        super(tag);
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString() {
        return "Punctuation{" +
               "tag=" + getTag() +
               ", symbol='" + symbol + '\'' +
               '}';
    }
}
