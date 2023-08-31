public class CharLiteral extends Token {
    private char value;
    
    public CharLiteral(char value, int line, int column) {
        super(Tag.CHAR_LITERAL, line, column);
        this.value = value;
    }
    
    public char getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "CharLiteral{" +
               "tag=" + getTag() +
               ", value=" + value +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}