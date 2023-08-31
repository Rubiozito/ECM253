public class ErrorToken extends Token {
    private String errorMessage;
    
    public ErrorToken(String errorMessage, int line, int column) {
        super(Tag.ERROR, line, column);
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    @Override
    public String toString() {
        return "ErrorToken{" +
               "tag=" + getTag() +
               ", errorMessage='" + errorMessage + '\'' +
               ", line=" + getLine() +
               ", column=" + getColumn() +
               '}';
    }
}