package frontend.Java;

import frontend.*;

/**
 * Base class for Java token classes
 */

public class JavaToken extends Token {
	 /**
     * Constructor.
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    protected JavaToken(Source source)
        throws Exception
    {
        super(source);
    }
}
