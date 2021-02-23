package frontend.Java;

import java.util.Hashtable;

import frontend.TokenType;

import java.util.HashSet;

/**
 * Java token types
 */

public enum JavaTokenType implements TokenType {

	// Reserved words
	ABSTRACT, ASSERT, BOOLEAN, BREAK, BYTE, CASE,
	CATCH, CHAR, CLASS, CONST, CONTINUE, DEFAULT,
	DO, DOUBLE, ELSE, ENUM, EXTENDS, FINAL, FINALLY,
	FLOAT, FOR, IF, GOTO, IMPLEMENTS, IMPORT, INSTANCEOF,
	INT, INTERFACE, LONG, NATIVE, NEW, PACKAGE, PRIVATE,
	PROTECTED, PUBLIC, RETURN, SHORT, STATIC, STRICTFP,
	SUPER, SWITCH, SYNCHRONIZED, THIS, THROW, THROWS,
	TRANSIENT, TRY, VOID, VOLATILE, WHILE, 

	// Special symbols
	ADDITION("+"), SUBTRACTION("-"),ANNOTATION("@"),INCREMENT("++"),LOGICAL_OR("||"),METHOD_REFERENCE("::"), MULTIPLICATION("*"), DIVISION("/"),EQUAL_TO("=="),
	DOT("."), COMMA(","), SEMICOLON(";"), COLON(":"),LAMBDA("->"),DOT_DOT_DOT("..."), SINGLE_QUOTE("'"),
	EQUALS("="), NOT_EQUALS("!="), LESS_THAN("<"), LESS_EQUALS("<="),DECREMENT("--"),
	GREATER_EQUALS(">="), GREATER_THAN(">"), LEFT_PAREN("("), RIGHT_PAREN(")"),BITWISE_COMPLIMENT("~"), LOGICAL_NOT("!"), CONDITIONAL("?"),
	BITWISE_AND("&"), BITWISE_OR("|"), MODULUS("%"), LEFT_SHIFT("<<"), RIGHT_SHIFT(">>"), ZERO_FILL_RIGHT_SHIFT(">>>"), ADD_ASSIGN("+="),
	SUBTRACT_ASSIGN("-="), MULTIPLY_ASSIGN("*="), DIVIDE_ASSIGN("/="), BITWISE_ASSIGN("&="), BITWISE_INCLUSIVE_OR("|="), BITWISE_XOR_ASSIGN("^="),
	MODULUS_ASSIGN("%="), LEFT_SHIFT_ASSIGN("<<="), RIGHT_SHIFT_ASSIGN(">>="), ASSIGNMENT(">>>="), 
	LEFT_BRACKET("["), RIGHT_BRACKET("]"), LEFT_BRACE("{"), RIGHT_BRACE("}"),
	BITWISE_XOR("^"), AND("&&"),

	IDENTIFIER, INTEGER, REAL, STRING,
	ERROR, END_OF_FILE;

	private static final int FIRST_RESERVED_INDEX = ABSTRACT.ordinal();
	private static final int LAST_RESERVED_INDEX  = WHILE.ordinal();

	private static final int FIRST_SPECIAL_INDEX = ADDITION.ordinal();
	private static final int LAST_SPECIAL_INDEX  = AND.ordinal();

	public String text;  // token text

	/**
	 * Constructor
	 */
	JavaTokenType(){
		this.text = this.toString().toLowerCase();
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * Constructor
	 * @param text the token text
	 */
	JavaTokenType(String text){
		this.text = text;
	}
	// Set of lower-cased Java reserved word text strings
	public static HashSet<String> RESERVED_WORDS = new HashSet<String>();
	static {
		JavaTokenType values[] = JavaTokenType.values();
		for(int i = FIRST_RESERVED_INDEX; i <= LAST_RESERVED_INDEX ; ++i ) {
			RESERVED_WORDS.add(values[i].getText().toLowerCase());
		}
	}
	// Hash table of Java special symbols. Each special symbol's text
	// is the key to its Java token type
	public static Hashtable<String, JavaTokenType> SPECIAL_SYMBOLS = new Hashtable<String, JavaTokenType>();
	static {
		JavaTokenType values[] = JavaTokenType.values();
		for (int i = FIRST_SPECIAL_INDEX; i <= LAST_SPECIAL_INDEX; ++i) {
			SPECIAL_SYMBOLS.put(values[i].getText(), values[i]);
		}
	}
}
