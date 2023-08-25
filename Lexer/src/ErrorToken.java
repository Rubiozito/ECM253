public class ErrorToken extends Token {
    private String errorMessage;
    
    public ErrorToken(String errorMessage) {
        super(Tag.ERROR);
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
               '}';
    }
}
