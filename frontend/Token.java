package frontend;

/**
 * This framework class represents a token returned by the scanner
 */
public class Token {
	protected TokenType type;		// language-specific token type
	protected String text;			// token type	
	protected Object value;			// token value
	protected Source source;		// source
	protected int lineNum;			// line number of the token's source line
	protected int position;			// position of the first token character
	
	/**
	 * Constructor
	 * @param source the source from where to fetch the token's characters.
	 * @throws Exception if an error occurred.
	 */
	public Token(Source source)
	throws Exception{
		this.source = source;
		this.lineNum = source.getLineNum();
		this.position = source.getPosition();
		
		extract();
	}

	/**
	 * @return the type
	 */
	public TokenType getType() {
		return type;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @return the lineNum
	 */
	public int getLineNumber() {
		return lineNum;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * Default method to extract only one-character tokens from the source.
	 * Subclass can override this method to construct language-specific tokens.
	 * After extracting the token, the current source line position
	 * will be one beyond the last token character.
	 * @throws Exception if an error occurred.
	 */
	protected void extract()
	throws Exception{
		text = Character.toString(currentChar());
		value = null;
		
		nextChar();		// consumer current character
	}
	
	/**
	 *  Call the source's currentChar() method.
	 * @return the current character from the source.
	 * @throws Exception if an error occurred.
	 */
	protected char currentChar()
	throws Exception{
		
		return source.currentChar();
	}
	
	/**
	 * Call the source's nextChar() method.
	 * @return the current character from the source.
	 * @throws Exception if an error occurred.
	 */	
	protected char nextChar()
	throws Exception{
		return source.nextChar();
	}
	/**
	 * Call the source's peekChar() method.
	 * @return the next character from the source without moving forward.
	 * @throws Exception if an error occurred.
	 */
	protected char peekChar()
	throws Exception{
		return source.peekChar();
	}
}
