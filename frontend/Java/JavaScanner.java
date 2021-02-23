package frontend.Java;

import static frontend.Source.EOF;
import static frontend.Source.EOL;

import frontend.*;
import frontend.tokens.*;
import static frontend.Java.JavaTokenType.*;
import static frontend.Java.JavaErrorCode.*;

/**
 * Java Scanner class
 */

public class JavaScanner extends Scanner {
	/**
	 * Constructor
	 * @param source the source to be used with this scanner.
	 */
	public JavaScanner(Source source) {
		super(source);
	}
	/**
	 * Extract and return the next Java token from the source.
	 * @return the next token.
	 * @throws Exception if an error occurred.
	 */
	public Token extractToken()
			throws Exception
	{
		skipWhiteSpace();

		Token token;
		char currentChar = currentChar();

		// Construct the next token.  The current character determines the
		// token type.
		if (currentChar == EOF) {
			token = new EofToken(source);
		}
		else if (currentChar == '.') {
			token = new JavaWordToken(source);
		}
		else if (currentChar == '"') {
			token = new JavaStringToken(source);
		}
		else if (Character.isLetter(currentChar)) {
			token = new JavaWordToken(source);
		}
		else if (Character.isDigit(currentChar)) {
			token = new JavaNumberToken(source);
		}
		else if (currentChar == '\'') {
			token = new JavaStringToken(source);
		}
		else if (JavaTokenType.SPECIAL_SYMBOLS
				.containsKey(Character.toString(currentChar))) {
			token = new JavaSpecialSymbolToken(source);
		}
		else {
			token = new JavaErrorToken(source, INVALID_CHARACTER,
					Character.toString(currentChar));
			nextChar();  // consume character
		}

		return token;
	}
	/**
	 * Skip whitespace characters by consuming them.  A comment is whitespace.
	 * @throws Exception if an error occurred.
	 */
	private void skipWhiteSpace()
			throws Exception
	{
		char currentChar = currentChar();

		while (Character.isWhitespace(currentChar) || (currentChar == '/')) {

			// Start of a comment?
			if (currentChar == '/') {
				currentChar = nextChar();
				if(currentChar == '/') {

				currentChar = nextChar();  // consume comment characters
				}
				do {
					currentChar = nextChar();  // consume comment characters

				}while(currentChar != EOL);
//			}while(currentChar != EOL ||(currentChar != EOF) );

			} 
			// Not a comment.
			else {
				currentChar = nextChar();  // consume whitespace character
			} 

		}
	}
}
