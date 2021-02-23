package frontend.Java;

import frontend.*;
import message.Message;

import static frontend.Java.JavaTokenType.*;
import static frontend.Java.JavaErrorCode.*;
import static message.MessageType.SYNTAX_ERROR;

/*
 * Error handler Java syntax errors
 */

public class JavaErrorHandler {
	private static final int MAX_ERRORS = 25;

    private static int errorCount = 0;   // count of syntax errors

	/**
	 * @return the errorCount
	 */
	public static int getErrorCount() {
		return errorCount;
	}
	/**
     * Flag an error in the source line.
     * @param token the bad token.
     * @param errorCode the error code.
     * @param parser the parser.
     * @return the flagger string.
     */
    public void flag(Token token, JavaErrorCode errorCode, Parser parser)
    {
        // Notify the parser's listeners.
        parser.sendMessage(new Message(SYNTAX_ERROR,
                                       new Object[] {token.getLineNumber(),		// source line number
                                                     token.getPosition(),		// beginning source position
                                                     token.getText(),			// token text
                                                     errorCode.toString()}));	// Syntax error message

        if (++errorCount > MAX_ERRORS) {
            abortTranslation(TOO_MANY_ERRORS, parser);
        }
    }
    /**
     * Abort the translation.
     * @param errorCode the error code.
     * @param parser the parser.
     */
    public void abortTranslation(JavaErrorCode errorCode, Parser parser)
    {
        // Notify the parser's listeners and then abort.
        String fatalText = "FATAL ERROR: " + errorCode.toString();
        parser.sendMessage(new Message(SYNTAX_ERROR,
                                       new Object[] {0,
                                                     0,
                                                     "",
                                                     fatalText}));
        System.exit(errorCode.getStatus());
    }

}
