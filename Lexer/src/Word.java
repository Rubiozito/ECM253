public class Word extends Token {
    private String lexeme;
    
    public Word(Tag tag, String lexeme, int line, int column) {
        super(tag, line, column);
        this.lexeme = lexeme;
    }
    
    public String getLexeme() {
        return lexeme;
    }
    
    @Override
    public String toString() {
        return "Word{" +
               "tag=" + getTag() +
               ", lexeme='" + lexeme + '\'' +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}
