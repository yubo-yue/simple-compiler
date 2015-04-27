package org.simple.compiler.frontend;

import java.io.BufferedReader;
import java.io.IOException;

import org.simple.compiler.message.Message;
import org.simple.compiler.message.MessageHandler;
import org.simple.compiler.message.MessageListener;
import org.simple.compiler.message.MessageProducer;
import org.simple.compiler.message.MessageType;

public class Source implements MessageProducer {

	public static final char EOL = '\n';
	public static final char EOF = (char) -1;
	
	private BufferedReader reader;
	private String line;
	private int lineNum;
	private int currentPos;
	
	private MessageHandler messageHandler;

	public Source(BufferedReader reader) {
		this.lineNum = 0;
		this.currentPos = -2;
		this.reader = reader;
		this.messageHandler = new MessageHandler();
	}

	
	public int getLineNum() {
		return lineNum;
	}


	public int getCurrentPos() {
		return currentPos;
	}
	
	public char currentChar() throws IOException {
		if (currentPos == -2) {
			readLine();
			return nextChar();
		}
		else if (line == null) {
			return EOF;
		}
		else if ((currentPos == -1) || (currentPos == line.length())) {
			return EOL;
		}
		
		else if(currentPos > line.length()) {
			readLine();
			return nextChar();
		}
		else {
			return line.charAt(currentPos);
		}
	}

	public char nextChar() throws IOException {
		++currentPos;
		return currentChar();
	}


	public void readLine() throws IOException {
		line = reader.readLine();
		currentPos = -1;
		
		if (null != line) {
			this.lineNum++;
		}
		
		if (null != line) {
			sendMessage(new Message(MessageType.SOURCE_LINE, new Object[]{lineNum, line}));
		}
	}


	public void addMessageListener(MessageListener listener) {

	}

	public void removeMessageListener(MessageListener listener) {

	}

	public void sendMessage(Message message) {

	}

}
