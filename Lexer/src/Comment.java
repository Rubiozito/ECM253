public class Comment extends Token {
    private String content;
    
    public Comment(String content) {
        super(Tag.COMMENT);
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
               '}';
    }
}
