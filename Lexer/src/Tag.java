public enum Tag {
    // Palavras reservadas
    IF, ELSE, WHILE, DO, INT, CHAR, VOID,
    
    // Identificador
    IDENTIFIER,
    
    // Constantes
    INTEGER_CONSTANT, HEX_CONSTANT, OCTAL_CONSTANT, REAL_CONSTANT,
    
    // Cadeias de caracteres e caracteres
    STRING, CHAR_LITERAL,
    
    // Operadores
    ARROW, INCREMENT, DECREMENT, AND, MULTIPLY, PLUS, MINUS, TILDE, NOT,
    
    // Pontuadores
    LEFT_BRACKET, RIGHT_BRACKET, LEFT_PAREN, RIGHT_PAREN, SEMICOLON, COMMA,
    
    // Ignorar espaços em branco e comentários
    WHITESPACE, COMMENT,
    
    // Erro
    ERROR
}
