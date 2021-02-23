package backend;

import backend.compiler.CodeGenerator;
import backend.interpreter.Executor;

/*
 * A factory class that creates compiler and interpreter components.
 */

public class BackendFactory {
	/*
	 * Creates a compiler or an interpreter back end component.
	 * @param operation either "compiler" or "execute"
	 * @return a compiler or an interpreter back end component.
	 * @throws Exception if an error occurred.
	 */
	public static Backend createBackend(String operation)
	        throws Exception
	    {
	        if (operation.equalsIgnoreCase("compile")) {
	            return new CodeGenerator();
	        }
	        else if (operation.equalsIgnoreCase("execute")) {
	            return new Executor();
	        }
	        else {
	            throw new Exception("Backend factory: Invalid operation '" +
	                                operation + "'");
	        }
	}
}
