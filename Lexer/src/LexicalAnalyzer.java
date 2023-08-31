import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicalAnalyzer {
    private String sourceCode;
    private int currentPosition;
    private int line;
    private int column;
    
    public LexicalAnalyzer(String sourceCode) {
        this.sourceCode = sourceCode;
        this.currentPosition = 0;
        this.line = 1;
        this.column = 1;
    }
    
    public List<Token> analyze() {
        List<Token> tokens = new ArrayList<>();
        
        while (currentPosition < sourceCode.length()) {
            char currentChar = sourceCode.charAt(currentPosition);
            
            if (Character.isWhitespace(currentChar)) {
                if (currentChar == '\n') {
                    line++;
                    column = 1;
                } else {
                    column++;
                }
                currentPosition++;
            } else if (currentChar == '/') {
                if (currentPosition + 1 < sourceCode.length() && sourceCode.charAt(currentPosition + 1) == '*') {
                    int commentStartLine = line;
                    int commentStartColumn = column;
                    currentPosition += 2;
                    column += 2;
                    
                    boolean commentClosed = false;
                    while (currentPosition < sourceCode.length() - 1) {
                        char commentChar = sourceCode.charAt(currentPosition);
                        char nextChar = sourceCode.charAt(currentPosition + 1);
                        
                        if (commentChar == '*' && nextChar == '/') {
                            commentClosed = true;
                            currentPosition += 2;
                            column += 2;
                            break;
                        } else if (commentChar == '\n') {
                            line++;
                            column = 1;
                        } else {
                            column++;
                        }
                        
                        currentPosition++;
                    }
                    
                    if (!commentClosed) {
                        tokens.add(new ErrorToken("Unclosed comment", commentStartLine, commentStartColumn));
                    }
                }
            } else if (currentChar == '"') {
                int stringStartLine = line;
                int stringStartColumn = column;
                currentPosition++;
                column++;
                
                StringBuilder value = new StringBuilder();
                while (currentPosition < sourceCode.length() && sourceCode.charAt(currentPosition) != '"') {
                    char stringChar = sourceCode.charAt(currentPosition);
                    if (stringChar == '\\') {
                        currentPosition++;
                        column++;
                        char escapedChar = sourceCode.charAt(currentPosition);
                        value.append(escapedChar);
                    } else {
                        value.append(stringChar);
                    }
                    currentPosition++;
                    column++;
                }
                
                if (currentPosition < sourceCode.length() && sourceCode.charAt(currentPosition) == '"') {
                    currentPosition++;
                    column++;
                    tokens.add(new StringLiteral(value.toString(), stringStartLine, stringStartColumn));
                } else {
                    tokens.add(new ErrorToken("Unclosed string literal", stringStartLine, stringStartColumn));
                }
            } else if (currentChar == '\'') {
                int charStartLine = line;
                int charStartColumn = column;
                currentPosition++;
                column++;
                
                char charValue;
                if (currentPosition + 2 < sourceCode.length() && sourceCode.charAt(currentPosition + 2) == '\'') {
                    charValue = sourceCode.charAt(currentPosition + 1);
                    currentPosition += 3;
                    column += 3;
                    tokens.add(new CharLiteral(charValue, charStartLine, charStartColumn));
                } else {
                    tokens.add(new ErrorToken("Invalid character literal", charStartLine, charStartColumn));
                }
            } else if (isDigit(currentChar)) {
                // Handle numeric constants
                int numberStartLine = line;
                int numberStartColumn = column;
                
                StringBuilder numberValue = new StringBuilder();
                while (currentPosition < sourceCode.length() && (isDigit(sourceCode.charAt(currentPosition)) || sourceCode.charAt(currentPosition) == '.')) {
                    char numberChar = sourceCode.charAt(currentPosition);
                    numberValue.append(numberChar);
                    currentPosition++;
                    column++;
                }
                
                try {
                    if (numberValue.toString().contains(".")) {
                        double realValue = Double.parseDouble(numberValue.toString());
                        tokens.add(new RealConstant(realValue, numberStartLine, numberStartColumn));
                    } else {
                        int intValue = Integer.parseInt(numberValue.toString());
                        tokens.add(new IntConstant(intValue, numberStartLine, numberStartColumn));
                    }
                } catch (NumberFormatException e) {
                    tokens.add(new ErrorToken("Invalid number format", numberStartLine, numberStartColumn));
                }
            } else if (isLetter(currentChar)) {
                // Handle words and keywords
                int wordStartLine = line;
                int wordStartColumn = column;
                
                StringBuilder wordValue = new StringBuilder();
                while (currentPosition < sourceCode.length() && (isLetter(sourceCode.charAt(currentPosition)) || isDigit(sourceCode.charAt(currentPosition)))) {
                    char wordChar = sourceCode.charAt(currentPosition);
                    wordValue.append(wordChar);
                    currentPosition++;
                    column++;
                }
                
                String wordString = wordValue.toString();
                if (isKeyword(wordString)) {
                    tokens.add(new Word(keywordToTag(wordString), wordString, wordStartLine, wordStartColumn));
                } else {
                    tokens.add(new Word(Tag.IDENTIFIER, wordString, wordStartLine, wordStartColumn));
                }
            } else {
                int operatorStartLine = line;
                int operatorStartColumn = column;
                
                String operator = Character.toString(currentChar);
                if (isOperatorSymbol(currentChar)) {
                    currentPosition++;
                    column++;
                    if (currentPosition < sourceCode.length() && isOperatorSymbol(sourceCode.charAt(currentPosition))) {
                        operator += sourceCode.charAt(currentPosition);
                        currentPosition++;
                        column++;
                    }
                    tokens.add(new Operator(getOperatorTag(operator), operator, operatorStartLine, operatorStartColumn));
                } else if (isPunctuationSymbol(currentChar)) {
                    tokens.add(new Punctuation(getPunctuationTag(operator), operator, operatorStartLine, operatorStartColumn));
                    currentPosition++;
                    column++;
                } else {
                    tokens.add(new ErrorToken("Invalid character", operatorStartLine, operatorStartColumn));
                    currentPosition++;
                    column++;
                }
            }
        }
        
        return tokens;
    }
    
    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
    
    private boolean isLetter(char c) {
        return Character.isLetter(c);
    }
    
    private boolean isOperatorSymbol(char c) {
        return "+-*/%=<>&|!^~".contains(Character.toString(c));
    }
    
    private boolean isPunctuationSymbol(char c) {
        return "[](),;".contains(Character.toString(c));
    }
    
    private Tag getOperatorTag(String operator) {
        switch (operator) {
            case "+": return Tag.PLUS;
            case "-": return Tag.MINUS;
            case "*": return Tag.MULTIPLY;
            case "++": return Tag.INCREMENT;
            case "--": return Tag.DECREMENT;
            case "->": return Tag.ARROW;
            case "&": return Tag.AND;
            case "!": return Tag.NOT;
            default: return Tag.ERROR;
        }
    }
    
    private Tag getPunctuationTag(String punctuation) {
        switch (punctuation) {
            case "(": return Tag.LEFT_PAREN;
            case ")": return Tag.RIGHT_PAREN;
            case "[": return Tag.LEFT_BRACKET;
            case "]": return Tag.RIGHT_BRACKET;
            case ",": return Tag.COMMA;
            case ";": return Tag.SEMICOLON;
            default: return Tag.ERROR;
        }
    }
    
    private boolean isKeyword(String word) {
        // Define the list of keywords
        String[] keywords = {"if", "else", "while", "do", "int", "char", "void"};
        return Arrays.asList(keywords).contains(word);
    }
    
    private Tag keywordToTag(String keyword) {
        switch (keyword) {
            case "if": return Tag.IF;
            case "else": return Tag.ELSE;
            case "while": return Tag.WHILE;
            case "do": return Tag.DO;
            case "int": return Tag.INT;
            case "char": return Tag.CHAR;
            case "void": return Tag.VOID;
            default: return Tag.IDENTIFIER;
        }
    }
    
    private static String getValueString(Token token) {
        if (token instanceof IntConstant) {
            return Integer.toString(((IntConstant) token).getValue());
        } else if (token instanceof HexConstant) {
            return ((HexConstant) token).getValue();
        } else if (token instanceof OctalConstant) {
            return ((OctalConstant) token).getValue();
        } else if (token instanceof RealConstant) {
            return Double.toString(((RealConstant) token).getValue());
        } else if (token instanceof StringLiteral) {
            return ((StringLiteral) token).getValue();
        } else if (token instanceof CharLiteral) {
            return Character.toString(((CharLiteral) token).getValue());
        } else if (token instanceof Operator || token instanceof Punctuation) {
            return ((Operator) token).getSymbol();
        } else {
            return "";
        }
    }
    
    public static void main(String[] args) {
        String sourceCode = "int main() {\n" +
                            "    int x = 10;\n" +
                            "    printf(\"Hello, world!\");\n" +
                            "    return 0;\n" +
                            "}";
        
        LexicalAnalyzer analyzer = new LexicalAnalyzer(sourceCode);
        List<Token> tokens = analyzer.analyze();
        
        for (Token token : tokens) {
            if (token.getTag() != Tag.WHITESPACE && token.getTag() != Tag.COMMENT && token.getTag() != Tag.ERROR) {
                System.out.println("Line: " + token.getLine() + ", Column: " + token.getColumn() +
                                   ", Tag: " + token.getTag() + ", Value: " + getValueString(token));
            }
        }
    }
}
