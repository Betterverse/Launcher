package org.spoutcraft.launcher.exceptions;

public class BadLoginException extends Exception {
	private static final long serialVersionUID = -2114049508501320797L;
	private final Throwable cause;
	private final String message;

	public BadLoginException(String message) {
		this(null, message);
	}

	public BadLoginException(Throwable throwable, String message) {
		this.cause = null;
		this.message = message;
	}

	public BadLoginException() {
		this(null, "Bad login");
	}

	@Override
	public Throwable getCause() {
		return this.cause;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
