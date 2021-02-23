package frontend;

import frontend.Java.JavaParserTD;
import frontend.Java.JavaScanner;

/* 
 * A factory class that creates parsers for specific source languages.
 */

public class FrontendFactory {
	/*
	 * Create a parser.
	 * @param language the name of the source language.
	 * @param type the type of parser.
	 * @param source the source object.
	 * @return the parser.
	 * @throws Exception if an error occurred.
	 */
	public static Parser createParser(String language, String type,
			Source source)
					throws Exception{
		if(language.equalsIgnoreCase("Java") &&
				type.equalsIgnoreCase("top-down")) {
			Scanner scanner = new JavaScanner(source);
			return new JavaParserTD(scanner);
		}
		else if(!language.equalsIgnoreCase("Java")) {
			throw new Exception("Parser factory: Invalid language '" +
					language + "'");
		}
		else {
			throw new Exception("Parser factory: Invalid type '" +
					type + "'");
		}
	}
}
