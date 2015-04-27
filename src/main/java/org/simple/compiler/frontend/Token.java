package org.simple.compiler.frontend;

public abstract class Token {
	protected TokenType tokenType;
	protected String text;
	protected Object value;
	protected Source source;
	private int lineNum;
	private int position;
	
	
}
