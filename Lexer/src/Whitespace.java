public class Whitespace extends Token {
    public Whitespace() {
        super(Tag.WHITESPACE);
    }
    
    @Override
    public String toString() {
        return "Whitespace{" +
               "tag=" + getTag() +
               '}';
    }
}
