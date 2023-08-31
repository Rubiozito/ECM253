public class Comment extends Token {
    private String content;
    
    public Comment(String content, int line, int column) {
        super(Tag.COMMENT, line, column);
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    @Override
    public String toString() {
        return "Comment{" +
               "tag=" + getTag() +
               ", content='" + content + '\'' +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}
