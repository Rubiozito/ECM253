public class Word extends Token {
    private String lexeme;
    
    public Word(Tag tag, String lexeme) {
        super(tag);
        this.lexeme = lexeme;
    }
    
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString() {
        return "Word [lexeme=" + lexeme + "]";
    }
    
  
}