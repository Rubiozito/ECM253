public class Whitespace extends Token {
    public Whitespace(int line, int column) {
        super(Tag.WHITESPACE, line, column);
    }
    
    @Override
    public String toString() {
        return "Whitespace{" +
               "tag=" + getTag() +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}