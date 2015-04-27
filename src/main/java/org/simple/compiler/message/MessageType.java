package org.simple.compiler.message;

public enum MessageType {
	SOURCE_LINE(0), SYNTAX_ERROR(1), PARSE_SUMMARY(2), INTERMEDIATE_SUMMARY(3), COMPILIER_SUMMARY(
			4), MISCELLANEOUS(5), TOKEN(6), ASSIGN(7), FETCH(8), BREAKPOINT(9), RUNTIME_ERROR(
			10), CALL(11), RETURN(12);

	private final int id;

	MessageType(int id) {
		this.id = id;
	}

	public int id() {
		return id;
	}
}
