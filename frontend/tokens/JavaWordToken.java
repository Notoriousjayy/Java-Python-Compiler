package frontend.tokens;

import frontend.*;
import frontend.Java.*;

import static frontend.Java.JavaTokenType.*;
/*
 * Java word tokens
 */

public class JavaWordToken extends JavaToken {
	    /**
	     * Constructor.
	     * @param source the source from where to fetch the token's characters.
	     * @throws Exception if an error occurred.
	     */
	    public JavaWordToken(Source source)
	        throws Exception
	    {
	        super(source);
	    }
	    /**
	     * Extract a Java word token from the source.
	     * @throws Exception if an error occurred.
	     */
	    protected void extract()
	        throws Exception
	    {
	    	char currentChar = currentChar();
	    	StringBuilder textBuffer = new StringBuilder();
	        

	        // Get the word characters (letter or digit or .).  The scanner has
	        // already determined that the first character is a letter.
	        while (Character.isLetterOrDigit(currentChar) || currentChar == '.' || currentChar == ',') {
	            textBuffer.append(currentChar);
	            currentChar = nextChar();  // consume character
	        }

	        text = textBuffer.toString();

	        // Is it a reserved word or an identifier?
	        type = (RESERVED_WORDS.contains(text.toLowerCase()))
	               ? JavaTokenType.valueOf(text.toUpperCase())  // reserved word
	               : IDENTIFIER;                                  // identifier
	    }

}
