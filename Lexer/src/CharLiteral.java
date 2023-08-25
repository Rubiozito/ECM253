public class CharLiteral extends Token {
    private char value;
    
    public CharLiteral(char value) {
        super(Tag.CHAR_LITERAL);
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
               '}';
    }
}
