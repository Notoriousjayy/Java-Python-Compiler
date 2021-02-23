package frontend.Java;

import message.Message;

import static message.MessageType.PARSER_SUMMARY;
import static frontend.Java.JavaTokenType.*;
import static frontend.Java.JavaErrorCode.*;
import static message.MessageType.*;

import frontend.*;

/*
 * A top-down Java parser
 */

public class JavaParserTD extends Parser{
	protected static JavaErrorHandler errorHandler = new JavaErrorHandler();

    /**
     * Constructor.
     * @param scanner the scanner to be used with this parser.
     */
	/**
	 * Constructor
	 * @param scanner the scanner to be used with this parser.
	 */
	public JavaParserTD(Scanner scanner) {
		super(scanner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parse a Java source program and generate the symbol table
	 * and the intermediate code.
	 */
	public void parse()
	throws Exception{
		
		Token token;
		long startTime = System.currentTimeMillis();
		
		try {
            // Loop over each token until the end of file.
            while (!((token = nextToken()) instanceof EofToken)) {
                TokenType tokenType = token.getType();

                if (tokenType != ERROR) {

                    // Format each token.
                    sendMessage(new Message(TOKEN,
                                            new Object[] {token.getLineNumber(),	// source line number
                                                          token.getPosition(),		// beginning source program
                                                          tokenType,				// token type
                                                          token.getText(),			// token text
                                                          token.getValue()}));		// token value
                }
                else {
                    errorHandler.flag(token, (JavaErrorCode) token.getValue(),
                                      this);
                }

            }

            // Send the parser summary message.
            float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
            sendMessage(new Message(PARSER_SUMMARY,
                                    new Number[] {token.getLineNumber(),	// source line number
                                                  getErrorCount(),
                                                  elapsedTime}));
        }
        catch (java.io.IOException ex) {
            errorHandler.abortTranslation(IO_ERROR, this);
        }
    }

	/**
	 * Return the number of syntax errors found by the parser.
	 * @return the error count.
	 */
	public int getErrorCount() {
        return errorHandler.getErrorCount();
	}
}
