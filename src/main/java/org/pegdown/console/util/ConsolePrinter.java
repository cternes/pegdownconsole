package org.pegdown.console.util;

public class ConsolePrinter {

	public static void printMessage(final String message) {
		System.out.println(message);
	}

	public static void printError(final String error) {
		printError(error, null);
	}

	public static void printError(final String error, final Exception e) {
		if(e != null) {
	    	System.err.println(error + e.getMessage() ); 
		}
		else {
	    	System.err.println(error);
		}
	}

}

