public class Token {
    private Tag tag;
    private int line;
    private int column;
    
    public Token(Tag tag, int line, int column) {
        this.tag = tag;
        this.line = line;
        this.column = column;
    }
    
    public Tag getTag() {
        return tag;
    }
    
    public int getLine() {
        return line;
    }
    
    public int getColumn() {
        return column;
    }
    
    @Override
    public String toString() {
        return "Token{" +
               "tag=" + tag +
               ", line=" + line +
               ", column=" + column +
               '}';
    }
}