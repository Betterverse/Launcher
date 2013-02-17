package org.spoutcraft.launcher.exceptions;

public class InvalidSkinException extends Exception {
	private static final long serialVersionUID = 5907555277800661037L;
	private final Throwable cause;
	private final String message;

	public InvalidSkinException(String message, Throwable cause) {
		this.cause = cause;
		this.message = message;
	}

	public InvalidSkinException(Throwable cause) {
		this(null, cause);
	}

	public InvalidSkinException(String message) {
		this(message, null);
	}

	public InvalidSkinException() {
		this(null, null);
	}

	@Override
	public Throwable getCause() {
		return this.cause;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
